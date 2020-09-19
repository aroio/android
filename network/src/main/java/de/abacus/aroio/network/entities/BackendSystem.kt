package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendSystem(
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
