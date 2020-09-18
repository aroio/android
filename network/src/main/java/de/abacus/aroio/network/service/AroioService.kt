package de.abacus.aroio.network.service

interface AroioService {
	suspend fun authenticate(username: String, password: String)
}