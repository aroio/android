package de.abacus.aroio.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object Client {
	
	@Volatile
	private var retrofit: Retrofit? = null
	private var baseUrl: String? = null
	
	internal fun getRetrofit(aroioIpAddress: String): Retrofit {
		if (this.baseUrl == aroioIpAddress) return requireNotNull(retrofit) {
			"If the baseUrl is equal to the given address, a Retrofit instance must be created already."
		}
		this.baseUrl = aroioIpAddress
		return createRetrofit(aroioIpAddress)
	}
	
	@OptIn(ExperimentalSerializationApi::class)
	private fun createRetrofit(baseUrl: String): Retrofit {
		val contentType = "application/json".toMediaType()
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(Json.asConverterFactory(contentType = contentType))
			.build()
	}
	
}