package de.lennartegb.nsd.extensions

import android.content.Context
import de.lennartegb.nsd.NetworkServiceDiscovery
import de.lennartegb.nsd.NetworkServiceDiscoveryImpl

fun Context.getNetworkServiceDiscovery(): NetworkServiceDiscovery =
	NetworkServiceDiscoveryImpl(this)
