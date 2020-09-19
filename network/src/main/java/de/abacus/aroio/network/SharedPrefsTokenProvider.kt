package de.abacus.aroio.network

import android.content.Context

internal class SharedPrefsTokenProvider(context: Context) : OAuthTokenProvider {
	
	companion object {
		private const val SHARED_PREFS_NAME = "de.abacus.aroio.network.shared_prefs"
		private const val TOKEN_KEY = "de.abacus.aroio.network.token_key"
	}
	
	private val sharedPrefs =
		context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
	
	override fun setToken(token: Token) {
		sharedPrefs.edit().putString(TOKEN_KEY, token).apply()
	}
	
	override fun getTokenOrNull(): Token? {
		return sharedPrefs.getString(TOKEN_KEY, null)
	}
}