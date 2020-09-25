package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WLANConfig(
	@SerialName("dhcp")
	val dhcp: Boolean,
	@SerialName("ipaddr")
	val ipaddr: String?,
	@SerialName("netmask")
	val netmask: String?,
	@SerialName("dnsserv")
	val dnsserv: String?,
	@SerialName("gateway")
	val gateway: String?,
	@SerialName("ssid")
	val ssid: String?,
	@SerialName("pwd")
	val pwd: String?,
)