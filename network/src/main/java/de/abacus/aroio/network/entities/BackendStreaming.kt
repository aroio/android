package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendStreaming(
	@SerialName("servername")
	val serverName: String?,
	@SerialName("serverport")
	val serverPort: String?,
	@SerialName("squeezeuser")
	val squeezeUser: String?,
	@SerialName("squeezepwd")
	val squeezePassword: String?,
	@SerialName("playername")
	val playerName: String,
)
