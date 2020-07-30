package de.abacuselectronics.aroiorc.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
	
	private val _aroios = MutableLiveData<List<Aroio>>(emptyList())
	val aroios: LiveData<List<Aroio>> = _aroios
	
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
		val list = _aroios.value ?: return
		val aroio: Aroio = getAroioFromService(service)
		_aroios.postValue(list.filter { it != aroio })
	}
	
	private fun serviceFound(service: NsdService) {
		val list = _aroios.value ?: return
		val aroio = getAroioFromService(service)
		_aroios.postValue(list.plus(aroio))
	}
	
	private fun getAroioFromService(service: NsdService): Aroio {
		TODO("Not yet implemented")
	}
	
}
