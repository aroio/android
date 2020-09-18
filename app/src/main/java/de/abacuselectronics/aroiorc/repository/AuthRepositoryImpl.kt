package de.abacuselectronics.aroiorc.repository

import de.abacus.aroio.network.service.AuthenticationService

class AuthRepositoryImpl(
	private val service: AuthenticationService
) : AuthRepository {
	
	override suspend fun authenticate(username: String, password: String) {
		val token = service.login(username, password)
		// TODO: 18.09.20 - store token within the client
	}
	
}