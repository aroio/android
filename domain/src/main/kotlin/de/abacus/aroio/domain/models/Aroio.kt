package de.abacus.aroio.domain.models

import java.util.*

data class Aroio(
	val id: Long,
	val name: String,
	val description: String,
	val timestamp: Date,
	val isAvailable: Boolean
)