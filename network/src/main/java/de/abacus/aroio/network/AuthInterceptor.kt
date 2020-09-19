package de.abacus.aroio.network

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor(
	private val oAuthTokenProvider: OAuthTokenProvider
) : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val builder = chain.request().newBuilder()
		oAuthTokenProvider.getTokenOrNull()?.let {
			builder.addHeader("Authorization", it)
		}
		return chain.proceed(builder.build())
	}
}