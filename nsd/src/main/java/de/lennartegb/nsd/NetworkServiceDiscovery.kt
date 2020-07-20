package de.lennartegb.nsd

import kotlinx.coroutines.flow.Flow

interface NetworkServiceDiscovery {
	fun discover(nsdInfo: NsdInfo): Flow<NsdResult>
}