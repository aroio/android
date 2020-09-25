package de.abacus.aroio.network.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthCredentials(
	@SerialName("username")
	val username: String,
	@SerialName("password")
	val password: String
)
