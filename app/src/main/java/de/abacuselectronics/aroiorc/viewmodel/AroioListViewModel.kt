package de.abacuselectronics.aroiorc.viewmodel

import android.content.Context
import androidx.lifecycle.*
import de.lennartegb.nsd.NetworkServiceDiscovery
import de.lennartegb.nsd.extensions.getNetworkServiceDiscovery
import de.lennartegb.nsd.model.NsdResult
import de.lennartegb.nsd.model.NsdService
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@OptIn(InternalCoroutinesApi::class)
class AroioListViewModel(
	private val networkServiceDiscovery: NetworkServiceDiscovery
) : ViewModel() {
	
	sealed class State {
		object NoDevicesFound : State()
		class DevicesAvailable(val aroioList: List<de.abacus.aroio.database.entities.Aroio>) :
			State()
	}
	
	private val aroioList =
		MutableLiveData<List<de.abacus.aroio.database.entities.Aroio>>(emptyList())
	
	val state: LiveData<State> = Transformations.map(aroioList) {
		return@map if (it.isEmpty()) State.NoDevicesFound
		else State.DevicesAvailable(it)
	}
	
	init {
		viewModelScope.launch {
			networkServiceDiscovery.discover().collect { result ->
				when (result) {
					is NsdResult.ServiceFound -> serviceFound(result.service)
					is NsdResult.ServiceLost -> serviceLost(result.service)
				}
			}
		}
	}
	
	private fun serviceLost(service: NsdService) {
		val list = aroioList.value ?: return
		val aroio: de.abacus.aroio.database.entities.Aroio =
			getAroioFromService(service)
		aroioList.postValue(list.filter { it != aroio })
	}
	
	private fun serviceFound(service: NsdService) {
		val list = aroioList.value ?: return
		val aroio = getAroioFromService(service)
		aroioList.postValue(list.plus(aroio))
	}
	
	private fun getAroioFromService(service: NsdService): de.abacus.aroio.database.entities.Aroio {
		return de.abacus.aroio.database.entities.Aroio(
			name = service.host.hostName,
			ipAddress = service.host.hostAddress
		)
	}
	
}

@Suppress("UNCHECKED_CAST")
class AroioListViewModelFactory(context: Context) : ViewModelProvider.Factory {
	private val nsd: NetworkServiceDiscovery =
		context.getNetworkServiceDiscovery()
	
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return AroioListViewModel(nsd) as T
	}
}