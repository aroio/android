package de.abacus.aroio.domain.repositories.impl

import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.daos.BaseDao
import de.abacus.aroio.domain.repositories.AroioRepository
import de.abacus.aroio.domain.repositories.Repository
import de.abacus.aroio.network.service.AroioService
import de.abacus.aroio.network.service.Service

/**
 * The provider to create repositories. This is the internal implementation for
 * the domain layer.
 * @param serviceProvider A [Service.Provider] to provide any services.
 * @param daoProvider A [BaseDao.Provider] to provide data access objects for data persistence.
 */
internal class RepositoryProvider(
	private val serviceProvider: Service.Provider,
	private val daoProvider: BaseDao.Provider,
) : Repository.Provider {


	@Suppress("UNCHECKED_CAST")
	override fun <REPO : Repository> create(className: Class<REPO>): REPO {
		return when {
			className.isAssignableFrom(AroioRepository::class.java) -> provideAroioRepository()
			else                                                    -> throw NotImplementedError(
				"Repository ${className.name} is not implemented."
			)
		} as REPO
	}


	private fun provideAroioRepository(): AroioRepository {
		return AroioRepository.newInstance(
			service = serviceProvider.get(AroioService::class.java),
			dao = daoProvider.get(AroioDao::class.java),
		)
	}

}