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
import java.net.InetAddress

class NetworkServiceDiscovery(context: Context) {
	
	sealed class Result {
		data class ServiceFound(val service: NsdServiceInfo) : Result()
		data class ServiceLost(val service: NsdServiceInfo) : Result()
	}
	
	companion object {
		// NOTE: The only protocol that can be used.
		private const val protocol = NsdManager.PROTOCOL_DNS_SD
	}
	
	private val dispatcher = IO
	private val discoveryJob = Job()
	private val coroutineScope = CoroutineScope(dispatcher + discoveryJob)
	
	private val nsdManager =
		(context.getSystemService(Context.NSD_SERVICE) as NsdManager)
	
	
	fun discover(nsdInfo: NsdInfo): Flow<Result> = flow<Result> {
		nsdManager.discoverServices(
			nsdInfo.get().serviceType,
			protocol,
			object : NsdManager.DiscoveryListener {
				override fun onServiceFound(serviceInfo: NsdServiceInfo?) {
					if (serviceInfo == null) return
					coroutineScope.launch { this@flow.emit(Result.ServiceFound(serviceInfo)) }
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
					coroutineScope.launch { this@flow.emit(Result.ServiceLost(serviceInfo)) }
				}
			})
	}.flowOn(dispatcher)

	@Suppress("unused")
	class NsdInfo {
		
		private val serviceInfo = NsdServiceInfo()
		
		fun setServiceName(serviceName: String) =
			apply { serviceInfo.serviceName = serviceName }
		
		fun setServiceType(serviceType: String) =
			apply { serviceInfo.serviceType = serviceType }
		
		fun setPort(port: Int) =
			apply { serviceInfo.port = port }
		
		fun setHost(host: InetAddress) =
			apply { serviceInfo.host = host }
		
		fun setHost(host: String) =
			apply { serviceInfo.host = InetAddress.getByName(host) }
		
		fun setAttribute(key: String, value: String) =
			apply { serviceInfo.setAttribute(key, value) }
		
		internal fun get() = serviceInfo
	}
	
}