package de.abacuselectronics.aroiorc.datasource.remote

import kotlinx.coroutines.delay

class AroioRemoteServiceImpl : AroioRemoteService {
	
	override suspend fun authenticate(
		ipAddress: String,
		username: String,
		password: String
	): Boolean {
		delay(1000)
		// TODO - debug purposes
		return true
	}
	
}