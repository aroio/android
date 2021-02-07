package de.abacus.aroio.database.daos.impl

import de.abacus.aroio.database.Database
import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.daos.BaseDao

internal class DaoProvider(private val database: Database) : BaseDao.Provider {

	@Suppress("UNCHECKED_CAST")
	override fun <DAO : BaseDao> get(daoName: Class<DAO>): DAO {
		return when {
			daoName.isAssignableFrom(AroioDao::class.java) -> database.aroioDao()
			else                                           -> throw NotImplementedError(
				"Dao $daoName is not implemented yet"
			)
		} as DAO
	}
}