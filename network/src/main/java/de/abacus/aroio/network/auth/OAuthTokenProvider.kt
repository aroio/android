package de.abacus.aroio.network.auth

interface OAuthTokenProvider {
	fun setToken(token: Token)
	fun getTokenOrNull(): Token?
}
