package de.abacuselectronics.aroiorc.datasource.remote

interface AroioRemoteService {
	suspend fun authenticate(
		ipAddress: String,
		username: String,
		password: String
	): Boolean
}
