package de.abacuselectronics.aroiorc.repository

import de.abacus.aroio.network.auth.OAuthTokenProvider
import de.abacus.aroio.network.entities.ChangePasswordInput
import de.abacus.aroio.network.service.AuthenticationService

class AuthRepositoryImpl(
	private val oAuthTokenProvider: OAuthTokenProvider,
	private val service: AuthenticationService
) : AuthRepository {
	
	override suspend fun authenticate(username: String, password: String) {
		val token = service.login(username, password)
		oAuthTokenProvider.setToken(token = token.accessToken)
	}
	
	override suspend fun changePassword(
		oldPassword: String,
		newPassword: String
	) {
		service.changePassword(ChangePasswordInput(oldPassword, newPassword))
	}
}