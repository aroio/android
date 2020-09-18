package de.abacus.aroio.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.abacus.aroio.database.daos.AroioDao
import de.abacus.aroio.database.entities.Aroio

@Database(entities = [Aroio::class], version = 1, exportSchema = false)
abstract class AroioDatabase : RoomDatabase() {
	abstract fun aroioDao(): AroioDao
}