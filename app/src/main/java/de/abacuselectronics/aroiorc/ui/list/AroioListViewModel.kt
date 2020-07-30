package de.abacuselectronics.aroiorc.ui.list

import androidx.lifecycle.*
import de.abacuselectronics.aroiorc.datasource.local.Aroio
import de.lennartegb.nsd.NetworkServiceDiscovery
import de.lennartegb.nsd.NsdInfo
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
		class DevicesAvailable(val aroioList: List<Aroio>) : State()
	}
	
	private val aroioList = MutableLiveData<List<Aroio>>(emptyList())
	
	val state: LiveData<State> = Transformations.map(aroioList) {
		return@map if (it.isEmpty()) State.NoDevicesFound
		else State.DevicesAvailable(it)
	}
	
	init {
		viewModelScope.launch {
			val nsdInfo = NsdInfo().setServiceType("_aroio._tcp")
			networkServiceDiscovery.discover(nsdInfo).collect { result ->
				when (result) {
					is NsdResult.ServiceFound -> serviceFound(result.service)
					is NsdResult.ServiceLost  -> serviceLost(result.service)
				}
			}
		}
	}
	
	private fun serviceLost(service: NsdService) {
		val list = aroioList.value ?: return
		val aroio: Aroio = getAroioFromService(service)
		aroioList.postValue(list.filter { it != aroio })
	}
	
	private fun serviceFound(service: NsdService) {
		val list = aroioList.value ?: return
		val aroio = getAroioFromService(service)
		aroioList.postValue(list.plus(aroio))
	}
	
	private fun getAroioFromService(service: NsdService): Aroio {
		TODO("Not yet implemented")
	}
	
}
