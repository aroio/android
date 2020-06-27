package de.lennartegb.nsd

import android.content.Context
import android.net.nsd.NsdManager
import android.net.nsd.NsdServiceInfo
import java.net.InetAddress

class NetworkServiceDiscovery private constructor(
	context: Context,
	private val serviceInfo: NsdServiceInfo
) {
	
	companion object {
		// NOTE: The only protocol that can be used.
		private const val protocol = NsdManager.PROTOCOL_DNS_SD
	}
	
	
	private val nsdManager =
		(context.getSystemService(Context.NSD_SERVICE) as NsdManager)
	
	
	fun discover() {
		nsdManager.discoverServices(
			serviceInfo.serviceType,
			protocol,
			object : NsdManager.DiscoveryListener {
				override fun onServiceFound(serviceInfo: NsdServiceInfo?) {
					if (serviceInfo == null) return
					TODO("Need service be emitted with found state")
				}
				
				override fun onStopDiscoveryFailed(
					serviceType: String?,
					errorCode: Int
				) {
					/* discovery stop failed is mostly not necessary and is ignored here  */
				}
				
				override fun onStartDiscoveryFailed(
					serviceType: String?,
					errorCode: Int
				) {
					/* discovery start failed is mostly not necessary and is ignored here  */
				}
				
				override fun onDiscoveryStarted(serviceType: String?) {
					/* discovery started is mostly not necessary and is ignored here */
				}
				
				override fun onDiscoveryStopped(serviceType: String?) {
					/* discovery stops is mostly not necessary and is ignored here  */
				}
				
				override fun onServiceLost(serviceInfo: NsdServiceInfo?) {
					if (serviceInfo == null) return
					TODO("Need service be emitted with lost state")
				}
			})
	}
	
	
	@Suppress("unused")
	class Builder(private val context: Context) {
		
		private val serviceInfo = NsdServiceInfo()
		
		fun setServiceName(serviceName: String) =
			apply { serviceInfo.serviceName = serviceName }
		
		fun setPort(port: Int) =
			apply { serviceInfo.port = port }
		
		fun setHost(host: InetAddress) =
			apply { serviceInfo.host = host }
		
		fun setHost(host: String) =
			apply { serviceInfo.host = InetAddress.getByName(host) }
		
		fun setServiceType(serviceType: String) =
			apply { serviceInfo.serviceType = serviceType }
		
		fun setAttribute(key: String, value: String) =
			apply { serviceInfo.setAttribute(key, value) }
		
		fun build(): NetworkServiceDiscovery {
			return NetworkServiceDiscovery(
				context = context,
				serviceInfo = serviceInfo
			)
		}
		
	}
	
}