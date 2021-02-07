package de.abacus.aroio.network.service

import de.abacus.aroio.network.models.Aroio
import retrofit2.http.GET

interface AroioService : Service {

	@GET("aroio")
	suspend fun getAroio(): Aroio

}