package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutputConfig(
	@SerialName("audio_output")
	val audioOutput: String,
	@SerialName("rate")
	val rate: Int,
	@SerialName("direct_config")
	val directConfig: PlayerConfig,
	@SerialName("bus_config")
	val busConfig: PlayerConfig,
	@SerialName("convolver_config")
	val convolverConfig: PlayerConfig,
)
