package de.abacus.aroio.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Aroio(
	@PrimaryKey(autoGenerate = true)
	val id: Long,
	val name: String,
	val description: String,
	val timestamp: Date,
	val isAvailable: Boolean
)
