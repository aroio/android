package de.abacus.aroio.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import de.abacus.aroio.network.auth.OAuthTokenProvider
import de.abacus.aroio.network.service.Service
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class Client(private val oauthTokenProvider: OAuthTokenProvider) :
	Service.Provider {

	override fun <SERVICE : Service> get(className: Class<SERVICE>): SERVICE {
		return getRetrofit(
			tokenProvider = oauthTokenProvider,
			aroioIpAddress = ""
		).create(className)
	}

	companion object {
		@Volatile
		private var retrofit: Retrofit? = null
		private var baseUrl: String? = null

		private fun getRetrofit(
			tokenProvider: OAuthTokenProvider,
			aroioIpAddress: String
		): Retrofit {
			if (this.baseUrl == aroioIpAddress) return requireNotNull(retrofit) {
				"If the baseUrl is equal to the given address, a Retrofit instance must be created already."
			}
			this.baseUrl = aroioIpAddress
			return createRetrofit(tokenProvider, aroioIpAddress)
		}

		private fun createRetrofit(
			oauthTokenProvider: OAuthTokenProvider,
			baseUrl: String
		): Retrofit {
			val interceptor = AuthInterceptor(oauthTokenProvider)
			val okHttpClient = OkHttpClient.Builder()
				.addInterceptor(interceptor = interceptor)
				.build()

			return Retrofit.Builder()
				.client(okHttpClient)
				.baseUrl(baseUrl)
				.addConverterFactory(JsonConfig.asConverterFactory(contentType = "application/json".toMediaType()))
				.build()
		}
	}

}