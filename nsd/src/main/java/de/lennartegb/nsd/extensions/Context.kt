package de.lennartegb.nsd.extensions

import android.content.Context
import android.net.nsd.NsdManager
import de.lennartegb.nsd.NetworkServiceDiscovery
import de.lennartegb.nsd.NetworkServiceDiscoveryImpl

fun Context.getNetworkServiceDiscovery(): NetworkServiceDiscovery {
	return NetworkServiceDiscoveryImpl(this)
}
