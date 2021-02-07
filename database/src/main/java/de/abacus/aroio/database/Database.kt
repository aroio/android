package de.abacus.aroio.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.entities.Aroio
import androidx.room.Database as DatabaseAnnotation

@DatabaseAnnotation(
	entities = [Aroio::class],
	version = 1,
	exportSchema = false
)
abstract class Database : RoomDatabase() {

	abstract fun aroioDao(): AroioDao


	companion object {

		private const val DB_NAME = "aroio_database.db"

		@Volatile
		private var instance: Database? = null

		fun getInstance(context: Context): Database {
			return instance ?: synchronized(this) {
				instance ?: Room.databaseBuilder(context, Database::class.java, DB_NAME)
					.build()
					.also { instance = it }
			}
		}

	}
}