package de.abacus.aroio.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import de.abacus.aroio.network.auth.OAuthTokenProvider
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

internal object Client {
	
	@Volatile
	private var retrofit: Retrofit? = null
	private var baseUrl: String? = null
	
	fun getRetrofit(
		tokenProvider: OAuthTokenProvider,
		aroioIpAddress: String
	): Retrofit {
		if (this.baseUrl == aroioIpAddress) return requireNotNull(retrofit) {
			"If the baseUrl is equal to the given address, a Retrofit instance must be created already."
		}
		this.baseUrl = aroioIpAddress
		return createRetrofit(tokenProvider, aroioIpAddress)
	}
	
	@OptIn(ExperimentalSerializationApi::class)
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