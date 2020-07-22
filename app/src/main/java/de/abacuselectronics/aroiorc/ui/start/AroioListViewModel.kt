package de.abacuselectronics.aroiorc.ui.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.lennartegb.nsd.NetworkServiceDiscovery
import de.lennartegb.nsd.NsdInfo
import de.lennartegb.nsd.NsdResult
import de.lennartegb.nsd.NsdService
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@OptIn(InternalCoroutinesApi::class)
class AroioListViewModel(
	private val networkServiceDiscovery: NetworkServiceDiscovery
) : ViewModel() {
	
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
		Log.i(this::class.java.simpleName, "Service lost: $service")
	}
	
	private fun serviceFound(service: NsdService) {
		Log.i(this::class.java.simpleName, "Service found: $service")
	}
	
}
