package de.abacuselectronics.aroiorc.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.abacuselectronics.aroiorc.datasource.local.Aroio
import de.lennartegb.nsd.NetworkServiceDiscovery
import de.lennartegb.nsd.model.NsdResult
import de.lennartegb.nsd.model.NsdService
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@OptIn(InternalCoroutinesApi::class)
class AroioListViewModel(
	private val networkServiceDiscovery: NetworkServiceDiscovery
) : ViewModel() {
	
	private val _aroioList = MutableLiveData<List<Aroio>>(emptyList())
	val aroioList: LiveData<List<Aroio>> = _aroioList
	
	init {
		viewModelScope.launch {
			networkServiceDiscovery.discover().collect { result ->
				when (result) {
					is NsdResult.ServiceFound -> serviceFound(result.service)
					is NsdResult.ServiceLost  -> serviceLost(result.service)
				}
			}
		}
	}
	
	private fun serviceLost(service: NsdService) {
		val list = requireNotNull(_aroioList.value)
		val aroio: Aroio = getAroioFromService(service)
		_aroioList.postValue(list.filter { it != aroio })
	}
	
	private fun serviceFound(service: NsdService) {
		val list = requireNotNull(_aroioList.value)
		val aroio = getAroioFromService(service)
		if (!list.contains(aroio)) {
			_aroioList.postValue(list.plus(aroio))
		}
	}
	
	private fun getAroioFromService(service: NsdService): Aroio {
		return Aroio(
			name = service.host.hostName,
			ipAddress = service.host.hostAddress
		)
	}
	
}
