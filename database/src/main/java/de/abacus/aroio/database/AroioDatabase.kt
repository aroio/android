package de.abacus.aroio.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.entities.Aroio

@Database(entities = [Aroio::class], version = 1, exportSchema = false)
abstract class AroioDatabase : RoomDatabase() {
	
	abstract fun aroioDao(): AroioDao
	
	
	companion object {
		
		private const val DB_NAME = "aroio_database.db"
		
		@Volatile
		private var instance: AroioDatabase? = null
		
		fun getInstance(context: Context): AroioDatabase {
			return instance ?: synchronized(this) {
				instance ?: createAroioDatabase(context).also { instance = it }
			}
		}
		
		private fun createAroioDatabase(context: Context): AroioDatabase {
			return Room.databaseBuilder(context, AroioDatabase::class.java, DB_NAME)
				.build()
		}
		
		
	}
}