package de.lennartegb.nsd

import android.content.Context
import android.net.nsd.NsdManager
import android.util.Log
import com.github.druk.rx2dnssd.BonjourService
import com.github.druk.rx2dnssd.Rx2DnssdEmbedded
import de.lennartegb.nsd.model.NsdResult
import de.lennartegb.nsd.model.NsdService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class NetworkServiceDiscoveryImpl(context: Context) :
	NetworkServiceDiscovery {
	
	companion object {
		private const val PROTOCOL = NsdManager.PROTOCOL_DNS_SD
	}
	
	private val dnssd = Rx2DnssdEmbedded(context)
	
	private val dispatcher = IO
	private val discoveryJob = Job()
	private val coroutineScope = CoroutineScope(dispatcher + discoveryJob)
	
	override fun discover(nsdInfo: NsdInfo): Flow<NsdResult> = flow {
		dnssd.browse("_http._tcp", "local.")
			.compose(dnssd.resolve())
			.subscribe { service ->
				Log.i(
					this@NetworkServiceDiscoveryImpl.javaClass.simpleName,
					service.toString()
				)
				val result = service?.toNsdService() ?: return@subscribe
				if (service.isLost) {
					coroutineScope.launch { emit(NsdResult.ServiceLost(result)) }
				} else {
					coroutineScope.launch { emit(NsdResult.ServiceFound(result)) }
				}
			}
	}.flowOn(dispatcher)
	
	private fun BonjourService.toNsdService(): NsdService {
		return NsdService(requireNotNull(hostname), port)
	}
	
}