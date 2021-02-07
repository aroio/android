package de.abacus.aroio.domain.repositories

import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.entities.Aroio
import de.abacus.aroio.domain.repositories.impl.AroioRepositoryImpl
import de.abacus.aroio.network.service.AroioService

interface AroioRepository : Repository {
	suspend fun getAllAvailable(): List<Aroio>

	companion object {

		fun newInstance(
			service: AroioService,
			dao: AroioDao,
		): AroioRepository = AroioRepositoryImpl(service = service, dao = dao)

	}
}