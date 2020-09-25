package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationContainer(
	@SerialName("network")
	val networkConfig: NetworkConfig,
	@SerialName("system")
	val systemConfig: SystemConfig,
	@SerialName("streaming")
	val streamingConfig: StreamingConfig,
	@SerialName("audio")
	val audioConfig: AudioConfig,
	@SerialName("convolver")
	val convolverConfig: ConvolverConfig,
)
