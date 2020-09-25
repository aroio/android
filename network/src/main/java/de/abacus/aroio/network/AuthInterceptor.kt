package de.abacus.aroio.network

import de.abacus.aroio.network.auth.OAuthTokenProvider
import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor(
	private val oAuthTokenProvider: OAuthTokenProvider
) : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val request = chain.request().newBuilder().apply {
			val token = oAuthTokenProvider.getTokenOrNull() ?: return@apply
			addHeader(
				"Authorization",
				"${token.tokenType} ${token.accessToken}"
			)
		}.build()
		return chain.proceed(request)
	}
}