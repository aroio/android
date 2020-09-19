package de.abacus.aroio.network

import android.content.Context

interface OAuthTokenProvider {
	fun setToken(token: Token)
	fun getTokenOrNull(): Token?
	
	companion object {
		
		@Volatile
		private var instance: OAuthTokenProvider? = null
		
		fun create(context: Context): OAuthTokenProvider {
			return instance ?: synchronized(this) {
				instance ?: SharedPrefsTokenProvider(context).also { instance = it }
			}
		}
	}
}
