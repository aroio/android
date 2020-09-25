package de.abacus.aroio.network.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthCredentials(
	val username: String,
	val password: String
)
