package de.lennartegb.nsd

import de.lennartegb.nsd.model.NsdResult
import kotlinx.coroutines.flow.Flow

interface NetworkServiceDiscovery {
	fun discover(): Flow<NsdResult>
	fun tearDown()
}