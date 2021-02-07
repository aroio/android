package de.abacus.aroio.network.service

import de.abacus.aroio.network.auth.AuthCredentials
import de.abacus.aroio.network.auth.Token
import de.abacus.aroio.network.models.ChangePasswordInput
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthenticationService {

	@POST("login")
	suspend fun login(@Body credentials: AuthCredentials): Token

	@PATCH("aroio/password")
	suspend fun changePassword(@Body passwordInput: ChangePasswordInput)

}