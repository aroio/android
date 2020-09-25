package de.abacus.aroio.network.auth

import de.abacus.aroio.network.AccessToken
import de.abacus.aroio.network.TokenType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
	@SerialName("access_token")
	val accessToken: AccessToken,
	@SerialName("token_type")
	val tokenType: TokenType,
	@SerialName("roles")
	val roles: List<UserRole>
)
