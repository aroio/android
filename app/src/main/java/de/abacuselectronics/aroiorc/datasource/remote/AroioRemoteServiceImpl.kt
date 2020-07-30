package de.abacuselectronics.aroiorc.datasource.remote

import kotlinx.coroutines.delay

class AroioRemoteServiceImpl(
	private val ipAddress: String
) : AroioRemoteService {
	
	override suspend fun authenticate(username: String, password: String): AuthResult {
		delay(1000)
		// TODO - debug purposes, needs correct authentication implementation
		val token = "91789a4de905211fdc6f1e519174a6b533e381cd"
		return AuthResult.Success(data = token)
	}
	
}