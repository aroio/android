package de.abacuselectronics.aroiorc.repository

interface AroioRepository {
	suspend fun authenticate(username: String, password: String)
}