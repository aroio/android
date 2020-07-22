package de.abacuselectronics.aroiorc.viewmodel.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartViewModel : ViewModel() {
	
	sealed class State {
		object Loading : State()
		object Success : State()
		class Fail(val exception: Exception) : State()
	}
	
	lateinit var ipAddress: String
	
	private val _state = MutableLiveData<State>()
	val state: LiveData<State> = _state
	
	fun login(username: String, password: String) = viewModelScope.launch(IO) {
		try {
			_state.postValue(State.Loading)
			tryLogin(username, password, ipAddress)
		} catch (uninitialized: UninitializedPropertyAccessException) {
			_state.postValue(State.Fail(uninitialized))
		}
	}
	
	private suspend fun tryLogin(
		username: String,
		password: String,
		ipAddress: String
	) {
		delay(1000)
		// TODO - Implement the login process. Currently only set state to success
		//        for debugging purposes.
		_state.postValue(State.Success)
	}
	
}