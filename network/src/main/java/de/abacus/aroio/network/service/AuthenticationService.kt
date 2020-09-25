package de.abacus.aroio.network.service

import de.abacus.aroio.network.Client
import de.abacus.aroio.network.auth.OAuthTokenProvider
import de.abacus.aroio.network.auth.AuthCredentials
import de.abacus.aroio.network.auth.Token
import de.abacus.aroio.network.entities.ChangePasswordInput
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthenticationService {

	@POST("login")
	suspend fun login(@Body credentials: AuthCredentials): Token

	@PATCH("aroio/password")
	suspend fun changePassword(@Body passwordInput: ChangePasswordInput)

	companion object {
		fun get(
			tokenProvider: OAuthTokenProvider,
			ipAddress: String
		): AuthenticationService {
			val client = Client.getRetrofit(tokenProvider, ipAddress)
			return client.create(AuthenticationService::class.java)
		}
	}
}