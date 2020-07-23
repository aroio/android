package de.abacuselectronics.aroiorc.datasource

interface AroioRemoteService {
	suspend fun authenticate(
		ipAddress: String,
		username: String,
		password: String
	): Boolean
}
