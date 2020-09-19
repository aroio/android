package de.abacus.aroio.network.service

import de.abacus.aroio.network.Client
import de.abacus.aroio.network.entities.BackendToken

interface AuthenticationService {
	suspend fun login(username: String, password: String): BackendToken
	
	companion object {
		
		fun get(ipAddress: String): AuthenticationService {
			val client = Client.getRetrofit(ipAddress)
			return client.create(AuthenticationService::class.java)
		}
		
	}
}