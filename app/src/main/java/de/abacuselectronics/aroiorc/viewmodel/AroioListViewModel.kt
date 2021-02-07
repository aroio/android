package de.abacuselectronics.aroiorc.viewmodel

import android.content.Context
import androidx.lifecycle.*
import de.abacus.aroio.domain.models.Aroio
import kotlinx.coroutines.launch

class AroioListViewModel(
) : ViewModel() {
	
	sealed class State {
		object NoDevicesFound : State()
		class DevicesAvailable(val aroioList: List<Aroio>) : State()
	}
	
	private val aroioList =
		MutableLiveData<List<Aroio>>(emptyList())
	
	val state: LiveData<State> = Transformations.map(aroioList) {
		return@map if (it.isEmpty()) State.NoDevicesFound
		else State.DevicesAvailable(it)
	}
	
	init {
		viewModelScope.launch {

		}
	}
}

@Suppress("UNCHECKED_CAST")
class AroioListViewModelFactory(context: Context) : ViewModelProvider.Factory {
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return AroioListViewModel() as T
	}
}