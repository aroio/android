package de.abacuselectronics.aroiorc.ui.start

import android.net.nsd.NsdServiceInfo
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.lennartegb.nsd.NetworkServiceDiscovery
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@OptIn(InternalCoroutinesApi::class)
class AroioListViewModel(private val networkServiceDiscovery: NetworkServiceDiscovery) :
	ViewModel() {
	
	private val nsdInfo = NetworkServiceDiscovery.NsdInfo()
		.setServiceType("_aroio._tcp")
	
	
	fun startDiscovery() = viewModelScope.launch {
		networkServiceDiscovery.discover(nsdInfo).collect { result ->
			when (result) {
				is NetworkServiceDiscovery.Result.ServiceFound -> serviceFound(result.service)
				is NetworkServiceDiscovery.Result.ServiceLost  -> serviceLost(result.service)
			}
		}
	}
	
	
	private fun serviceLost(service: NsdServiceInfo) {
		Log.i(this::class.java.simpleName, "Service lost: $service")
	}
	
	private fun serviceFound(service: NsdServiceInfo) {
		Log.i(this::class.java.simpleName, "Service found: $service")
	}
	
}
