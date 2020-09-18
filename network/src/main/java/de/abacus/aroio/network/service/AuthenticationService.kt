package de.abacus.aroio.network.service

import de.abacus.aroio.network.Client
import de.abacus.aroio.network.Token

interface AuthenticationService {
	suspend fun login(username: String, password: String): Token
	
	companion object {
		
		fun get(ipAddress: String): AuthenticationService {
			val client = Client.getRetrofit(ipAddress)
			return client.create(AuthenticationService::class.java)
		}
		
	}
}