package de.lennartegb.nsd

import android.content.Context
import android.util.Log
import com.github.druk.rx2dnssd.BonjourService
import com.github.druk.rx2dnssd.Rx2DnssdEmbedded
import de.lennartegb.nsd.model.NsdResult
import de.lennartegb.nsd.model.NsdService
import io.reactivex.schedulers.Schedulers
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
		private val TAG: String
			get() = NetworkServiceDiscoveryImpl::class.java.simpleName
	}
	
	private val dnssd = Rx2DnssdEmbedded(context)
	private val dispatcher = IO
	private val discoveryJob = Job()
	private val coroutineScope = CoroutineScope(dispatcher + discoveryJob)
	
	override fun discover(): Flow<NsdResult> = flow {
		dnssd.browse("_aroio._tcp", "local.")
			.compose(dnssd.resolve())
			.subscribeOn(Schedulers.io())
			.subscribe { service ->
				Log.i(TAG, service.toString())
				val result = service?.toNsdService() ?: return@subscribe
				if (service.isLost) {
					coroutineScope.launch { emit(NsdResult.ServiceLost(result)) }
				} else {
					coroutineScope.launch { emit(NsdResult.ServiceFound(result)) }
				}
			}
	}.flowOn(dispatcher)
	
	override fun tearDown() {
		discoveryJob.cancel()
	}
	
	private fun BonjourService.toNsdService(): NsdService {
		return NsdService(requireNotNull(inet4Address), port)
	}
	
}