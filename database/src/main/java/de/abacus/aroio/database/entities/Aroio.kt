package de.abacus.aroio.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Aroio(
	@PrimaryKey(autoGenerate = true)
	val id: Long,
	val name: String,
	val ipAddress: String,
	val isAvailable: Boolean
)
