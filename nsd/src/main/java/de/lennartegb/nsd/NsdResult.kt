package de.lennartegb.nsd

import android.net.nsd.NsdServiceInfo

sealed class NsdResult {
	class ServiceFound(val service: NsdServiceInfo) : NsdResult()
	class ServiceLost(val service: NsdServiceInfo) : NsdResult()
}