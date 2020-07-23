package de.abacuselectronics.aroiorc.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.abacuselectronics.aroiorc.datasource.remote.AroioRemoteService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginViewModel(
	private val ipAddress: String,
	private val remoteService: AroioRemoteService
) : ViewModel() {
	
	sealed class State {
		object Loading : State()
		object Success : State()
		class Fail(val reason: FailReason) : State()
	}
	
	sealed class FailReason {
		object InvalidInput : FailReason()
		object AuthenticationFailed : FailReason()
	}
	
	private val _state = MutableLiveData<State>()
	val state: LiveData<State> = _state
	
	fun login(username: String, password: String) = viewModelScope.launch(IO) {
		_state.postValue(State.Loading)
		val state = tryLogin(username, password)
		_state.postValue(state)
	}
	
	private suspend fun tryLogin(username: String, password: String): State {
		if (username.isBlank() or password.isBlank()) {
			return State.Fail(FailReason.InvalidInput)
		}
		
		return if (remoteService.authenticate(ipAddress, username, password)) {
			State.Success
		} else {
			State.Fail(FailReason.AuthenticationFailed)
		}
	}
	
}