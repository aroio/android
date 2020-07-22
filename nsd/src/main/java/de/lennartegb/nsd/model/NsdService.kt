package de.lennartegb.nsd.model

import java.net.InetAddress

data class NsdService(val host: InetAddress, val port: Int)