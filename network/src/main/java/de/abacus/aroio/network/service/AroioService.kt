package de.abacus.aroio.network.service

import de.abacus.aroio.network.Client
import de.abacus.aroio.network.OAuthTokenProvider
import de.abacus.aroio.network.entities.BackendAroio
import retrofit2.http.GET

interface AroioService {
	
	@GET("aroio")
	suspend fun getAroio(): BackendAroio
	
	companion object {
		fun get(
			oauthTokenProvider: OAuthTokenProvider,
			ipAddress: String
		): AroioService {
			val client = Client.getRetrofit(oauthTokenProvider, ipAddress)
			return client.create(AroioService::class.java)
		}
	}
}