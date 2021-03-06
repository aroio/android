package de.abacus.aroio.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChangePasswordInput(
	@SerialName("old_password")
	val oldPassword: String,
	@SerialName("new_password")
	val newPassword: String,
)
