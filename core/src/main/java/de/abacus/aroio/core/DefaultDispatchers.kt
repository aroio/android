package de.abacus.aroio.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DefaultDispatchers : DispatcherProvider {
	override val io: CoroutineDispatcher
		get() = Dispatchers.IO
	override val main: CoroutineDispatcher
		get() = Dispatchers.Main
	override val default: CoroutineDispatcher
		get() = Dispatchers.Default
	override val unconfined: CoroutineDispatcher
		get() = Dispatchers.Unconfined
}
