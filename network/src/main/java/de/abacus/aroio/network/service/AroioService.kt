package de.abacus.aroio.network.service

import de.abacus.aroio.network.Client
import de.abacus.aroio.network.entities.BackendAroio

interface AroioService {
	suspend fun getAroio(): BackendAroio
	
	companion object {
		fun get(ipAddress: String): AroioService {
			val client = Client.getRetrofit(ipAddress)
			return client.create(AroioService::class.java)
		}
	}
}