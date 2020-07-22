package de.lennartegb.nsd

sealed class NsdResult {
	class ServiceFound(val service: NsdService) : NsdResult()
	class ServiceLost(val service: NsdService) : NsdResult()
}