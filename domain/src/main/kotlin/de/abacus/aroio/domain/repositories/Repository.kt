package de.abacus.aroio.domain.repositories

import android.content.Context
import de.abacus.aroio.database.daos.BaseDao
import de.abacus.aroio.domain.repositories.impl.RepositoryProvider
import de.abacus.aroio.network.auth.OAuthTokenProvider
import de.abacus.aroio.network.service.Service

/**
 * Contract of a Repository. It is not containing any override methods, because each [Repository]
 * is free in its implementation.
 */
interface Repository {

	/**
	 * Provider for objects of type [Repository]
	 */
	interface Provider {
		/**
		 *  Creates a [Repository] based on its class name.
		 *  @param className of the [Repository] to create.
		 *  @return Repository
		 */
		fun <REPO : Repository> create(className: Class<REPO>): REPO


		companion object {
			fun createProvider(
				oAuthTokenProvider: OAuthTokenProvider,
				context: Context,
			): Provider {
				return RepositoryProvider(
					serviceProvider = Service.getProvider(oAuthTokenProvider),
					daoProvider = BaseDao.getProvider(context)
				)
			}
		}
	}
}