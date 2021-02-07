package de.abacus.aroio.database.daos

import android.content.Context
import de.abacus.aroio.database.Database
import de.abacus.aroio.database.daos.impl.DaoProvider

interface BaseDao {
	interface Provider {
		fun <DAO : BaseDao> get(daoName: Class<DAO>): DAO
	}

	companion object {

		fun getProvider(context: Context): Provider =
			DaoProvider(Database.getInstance(context))

	}
}