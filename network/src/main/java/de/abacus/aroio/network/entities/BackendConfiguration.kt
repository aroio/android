package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendConfiguration(
	@SerialName("network")
	val network: BackendNetwork,
	@SerialName("system")
	val system: BackendSystem,
	@SerialName("streaming")
	val streaming: BackendStreaming,
	@SerialName("audio")
	val audio: BackendAudio,
	@SerialName("convolver")
	val convolver: BackendConvolver,
)
