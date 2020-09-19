package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendAroio(
	@SerialName("name")
	val name: String,
	@SerialName("description")
	val description: String,
	@SerialName("timestamp")
	val timestamp: Float,
	@SerialName("configuration")
	val configuration: BackendConfiguration,
)
