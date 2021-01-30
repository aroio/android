package de.abacus.aroio.network.auth

import de.abacus.aroio.network.primitives.AccessToken
import de.abacus.aroio.network.primitives.TokenType
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
	@Contextual
	@SerialName("access_token")
	val accessToken: AccessToken,
	@Contextual
	@SerialName("token_type")
	val tokenType: TokenType,
	@SerialName("roles")
	val roles: List<UserRole>
)
