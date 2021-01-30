package de.abacus.aroio.domain.repositories.impl

import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.entities.Aroio
import de.abacus.aroio.domain.repositories.AroioRepository
import de.abacus.aroio.network.service.AroioService

class AroioRepositoryImpl(
	private val service: AroioService,
	private val dao: AroioDao
) : AroioRepository {
	
	override suspend fun getAllAvailable(): List<Aroio> {
		// TODO: 18.09.20 - run nsd for accessing available aroios
		return dao.getAvailable()
	}
	
}