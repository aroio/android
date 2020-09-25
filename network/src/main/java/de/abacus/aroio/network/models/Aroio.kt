package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Aroio(
	@SerialName("name")
	val name: String,
	@SerialName("description")
	val description: String,
	@SerialName("timestamp")
	val timestamp: Float,
	@SerialName("configuration")
	val configurationContainer: ConfigurationContainer,
)
