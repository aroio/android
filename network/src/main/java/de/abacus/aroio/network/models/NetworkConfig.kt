package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkConfig(
	@SerialName("hostname")
	val hostname: String,
	@SerialName("wifi")
	val wifi: Boolean,
	@SerialName("lan")
	val lan: LANConfig,
	@SerialName("wlan")
	val wlan: WLANConfig,
)
