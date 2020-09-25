package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamingConfig(
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
