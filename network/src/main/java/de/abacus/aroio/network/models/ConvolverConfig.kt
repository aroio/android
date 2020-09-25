package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConvolverConfig(
	@SerialName("debug")
	val isDebug: Boolean,
	@SerialName("load_prefilter")
	val loadPreFilter: Boolean,
	@SerialName("brutefir")
	val bruteFir: Boolean,
	@SerialName("def_coeff")
	val defCoeff: Int?,
	@SerialName("filters")
	val filters: List<ConvolverFilter>,
)
