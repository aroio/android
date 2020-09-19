package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendPlayerConfiguration(
	@SerialName("mscoding")
	val mscoding: Boolean,
	@SerialName("measurement_output")
	val measurementOutput: String,
	@SerialName("squeezelite")
	val squeezeLite: Boolean,
	@SerialName("gmediarender")
	val gMediaRender: Boolean,
	@SerialName("shairportsync")
	val shairPortSync: Boolean,
	@SerialName("bluealsaaplay")
	val blueAlsaaPlay: Boolean,
	@SerialName("input")
	val input: Boolean,
	@SerialName("netjack")
	val netJack: Boolean,
)
