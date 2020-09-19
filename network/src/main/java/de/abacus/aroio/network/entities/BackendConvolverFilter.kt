package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendConvolverFilter(
	@SerialName("id")
	val id: Int,
	@SerialName("is_active")
	val isActive: Boolean,
	@SerialName("coeff_name")
	val coeffName: String?,
	@SerialName("coeff_comment")
	val coeffComment: String?,
	@SerialName("coeff_att")
	val coeffAtt: String?,
	@SerialName("coeff_delay")
	val coeffDelay: String?,
)
