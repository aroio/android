package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SystemConfig(
	@SerialName("updateserver")
	val updateServer: String,
	@SerialName("usebeta")
	val useBeta: Boolean,
	@SerialName("platform")
	val platform: String,
	@SerialName("known_version")
	val knownVersion: String,
	@SerialName("btkey")
	val btkey: String,
)
