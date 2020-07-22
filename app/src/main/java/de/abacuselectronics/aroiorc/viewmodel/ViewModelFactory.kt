package de.abacuselectronics.aroiorc.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.abacuselectronics.aroiorc.ui.start.AroioListViewModel
import de.lennartegb.nsd.extensions.getNetworkServiceDiscovery

class ViewModelFactory(private val context: Context) :
	ViewModelProvider.Factory {
	
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		when {
			modelClass.isAssignableFrom(AroioListViewModel::class.java) -> {
				val nsd = context.getNetworkServiceDiscovery()
				return AroioListViewModel(nsd) as T
			}
			else                                                        -> {
				throw IllegalStateException("Unknown ViewModel could not be created")
			}
		}
	}
	
}
