package de.abacuselectronics.aroiorc.datasource.remote

sealed class AuthResult {
	data class Success(val data: String) : AuthResult()
	data class Failure(val throwable: Throwable) : AuthResult()
}

interface AroioRemoteService {
	suspend fun authenticate(username: String, password: String): AuthResult
}
