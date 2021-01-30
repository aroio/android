package de.abacus.aroio.domain.repositories

interface AuthRepository {
	suspend fun authenticate(username: String, password: String)
	suspend fun changePassword(oldPassword: String, newPassword: String)
}