package de.abacus.aroio.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.abacus.aroio.database.entities.Aroio

@Dao
interface AroioDao : BaseDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun upsert(aroio: Aroio)

	@Query("SELECT * FROM Aroio WHERE id = :id LIMIT 1")
	suspend fun get(id: Long): Aroio

	@Query("SELECT * FROM Aroio WHERE isAvailable = 1")
	suspend fun getAvailable(): List<Aroio>

}