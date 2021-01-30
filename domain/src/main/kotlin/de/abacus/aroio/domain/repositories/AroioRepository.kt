package de.abacus.aroio.domain.repositories

import de.abacus.aroio.database.entities.Aroio

interface AroioRepository {
	suspend fun getAllAvailable(): List<Aroio>
}