package de.abacus.aroio.network.service

import de.abacus.aroio.network.entities.BackendAroio

interface AroioService {
	suspend fun getAroio(): BackendAroio
}