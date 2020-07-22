package de.lennartegb.nsd

import android.content.Context
import android.net.nsd.NsdManager
import android.net.nsd.NsdServiceInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class NetworkServiceDiscoveryImpl(context: Context) : NetworkServiceDiscovery {
	
	companion object {
		// NOTE: The only protocol that can be used.
		private const val protocol = NsdManager.PROTOCOL_DNS_SD
	}
	
	private val dispatcher = IO
	private val discoveryJob = Job()
	private val coroutineScope = CoroutineScope(dispatcher + discoveryJob)
	
	private val nsdManager =
		(context.getSystemService(Context.NSD_SERVICE) as NsdManager)
	
	
	override fun discover(nsdInfo: NsdInfo): Flow<NsdResult> = flow {
		nsdManager.discoverServices(
			nsdInfo.get().serviceType,
			protocol,
			object : NsdManager.DiscoveryListener {
				override fun onServiceFound(serviceInfo: NsdServiceInfo?) {
					if (serviceInfo == null) return
					val nsdService = NsdService(serviceInfo.host, serviceInfo.port)
					coroutineScope.launch {
						this@flow.emit(NsdResult.ServiceFound(nsdService))
					}
				}
				
				override fun onStopDiscoveryFailed(
					serviceType: String?,
					errorCode: Int
				) {
					nsdManager.stopServiceDiscovery(this)
				}
				
				override fun onStartDiscoveryFailed(
					serviceType: String?,
					errorCode: Int
				) {
					nsdManager.stopServiceDiscovery(this)
				}
				
				override fun onDiscoveryStarted(serviceType: String?) {
					/* discovery started is mostly not necessary and is ignored here */
				}
				
				override fun onDiscoveryStopped(serviceType: String?) {
					/* discovery stops is mostly not necessary and is ignored here  */
				}
				
				override fun onServiceLost(serviceInfo: NsdServiceInfo?) {
					if (serviceInfo == null) return
					val nsdService = NsdService(serviceInfo.host, serviceInfo.port)
					coroutineScope.launch {
						this@flow.emit(NsdResult.ServiceLost(nsdService))
					}
				}
			})
	}.flowOn(dispatcher)
	
}