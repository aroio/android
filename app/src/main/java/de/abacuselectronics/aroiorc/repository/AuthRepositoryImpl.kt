package de.abacuselectronics.aroiorc.repository

import de.abacus.aroio.network.auth.AuthCredentials
import de.abacus.aroio.network.auth.OAuthTokenProvider
import de.abacus.aroio.network.models.ChangePasswordInput
import de.abacus.aroio.network.service.AuthenticationService

class AuthRepositoryImpl(
	private val oAuthTokenProvider: OAuthTokenProvider,
	private val service: AuthenticationService
) : AuthRepository {
	
	override suspend fun authenticate(username: String, password: String) {
		val credentials = AuthCredentials(username, password)
		val token = service.login(credentials)
		oAuthTokenProvider.setToken(token = token)
	}
	
	override suspend fun changePassword(
		oldPassword: String,
		newPassword: String
	) {
		service.changePassword(ChangePasswordInput(oldPassword, newPassword))
	}
}