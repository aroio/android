package de.abacuselectronics.aroiorc.repository

interface AuthRepository {
	suspend fun authenticate(username: String, password: String)
	suspend fun changePassword(oldPassword: String, newPassword: String)
}