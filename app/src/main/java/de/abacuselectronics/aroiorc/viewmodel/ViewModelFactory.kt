package de.abacuselectronics.aroiorc.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.abacuselectronics.aroiorc.datasource.remote.AroioRemoteServiceImpl
import de.abacuselectronics.aroiorc.ui.list.AroioListViewModel
import de.abacuselectronics.aroiorc.ui.login.LoginViewModel
import de.lennartegb.nsd.extensions.getNetworkServiceDiscovery

class ViewModelFactory(
	private val context: Context? = null,
	private val ipAddress: String? = null
) : ViewModelProvider.Factory {
	
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(AroioListViewModel::class.java)) {
			val nsd = requireNotNull(context).getNetworkServiceDiscovery()
			return AroioListViewModel(nsd) as T
		}
		
		if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
			return LoginViewModel(
				AroioRemoteServiceImpl(requireNotNull(ipAddress))
			) as T
		}
		
		throw IllegalStateException("Unknown ViewModel could not be created")
	}
	
}
