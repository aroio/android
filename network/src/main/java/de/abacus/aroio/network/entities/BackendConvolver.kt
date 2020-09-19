package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendConvolver(
	@SerialName("debug")
	val isDebug: Boolean,
	@SerialName("load_prefilter")
	val loadPreFilter: Boolean,
	@SerialName("brutefir")
	val bruteFir: Boolean,
	@SerialName("def_coeff")
	val defCoeff: Int?,
	@SerialName("filters")
	val filters: List<BackendConvolverFilter>,
)
