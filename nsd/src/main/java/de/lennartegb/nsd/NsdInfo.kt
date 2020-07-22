package de.lennartegb.nsd

import android.net.nsd.NsdServiceInfo
import java.net.InetAddress

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