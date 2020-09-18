package de.abacuselectronics.aroiorc.repository

import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.network.service.AroioService

class AroioRepositoryImpl(
	private val service: AroioService,
	private val dao: AroioDao
) : AroioRepository {
	
	override suspend fun authenticate(username: String, password: String) {
		service.authenticate(username, password)
	}
	
}