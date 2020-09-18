package de.abacuselectronics.aroiorc.repository

import de.abacus.aroio.database.entities.Aroio

interface AroioRepository {
	suspend fun getAllAvailable(): List<Aroio>
}