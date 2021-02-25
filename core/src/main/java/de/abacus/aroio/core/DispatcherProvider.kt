package de.abacus.aroio.core

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provider for [CoroutineDispatcher]s.
 */
interface DispatcherProvider {
	val io: CoroutineDispatcher
	val main: CoroutineDispatcher
	val default: CoroutineDispatcher
	val unconfined: CoroutineDispatcher

	companion object {
		val default: DispatcherProvider = DefaultDispatchers()
	}
}