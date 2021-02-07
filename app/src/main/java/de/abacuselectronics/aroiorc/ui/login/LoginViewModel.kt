package de.abacuselectronics.aroiorc.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

	sealed class State {
		object Loading : State()
		object Success : State()
		data class Failure(val reason: FailReason) : State()
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
			return State.Failure(FailReason.InvalidInput)
		}
		return State.Success
	}
}

