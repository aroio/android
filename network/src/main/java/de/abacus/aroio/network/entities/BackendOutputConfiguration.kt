package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendOutputConfiguration(
	@SerialName("audio_output")
	val audioOutput: String,
	@SerialName("rate")
	val rate: Int,
	@SerialName("direct_config")
	val directConfig: BackendPlayerConfiguration,
	@SerialName("bus_config")
	val busConfig: BackendPlayerConfiguration,
	@SerialName("convolver_config")
	val convolverConfig: BackendPlayerConfiguration,
)
