package de.abacus.aroio.network.service

import de.abacus.aroio.network.Client
import de.abacus.aroio.network.auth.OAuthTokenProvider

/**
 * A Service that can be provided by [Service.Provider].
 */
interface Service {

	/**
	 * A Provider for [Service]s.
	 */
	interface Provider {
		fun <SERVICE : Service> get(className: Class<SERVICE>): SERVICE
	}

	companion object {
		fun getProvider(oAuthTokenProvider: OAuthTokenProvider): Provider =
			Client(oauthTokenProvider = oAuthTokenProvider)
	}
}