package de.abacuselectronics.aroiorc.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.abacuselectronics.aroiorc.datasource.AroioRemoteService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class InvalidInputException(message: String) : IllegalArgumentException(message)
class AuthenticationException(message: String) :
	IllegalArgumentException(message)


class LoginViewModel(
	private val ipAddress: String,
	private val remoteService: AroioRemoteService
) : ViewModel() {
	
	sealed class State {
		object Loading : State()
		object Success : State()
		class Fail(val exception: Exception) : State()
	}
	
	private val _state = MutableLiveData<State>()
	val state: LiveData<State> = _state
	
	fun login(username: String, password: String) = viewModelScope.launch(IO) {
		_state.postValue(State.Loading)
		val state = tryLogin(username, password)
		_state.postValue(state)
	}
	
	private suspend fun tryLogin(username: String, password: String): State {
		return when {
			username.isBlank() || password.isBlank()                  -> {
				val message = "Expected username and password to be not blank"
				State.Fail(InvalidInputException(message))
			}
			remoteService.authenticate(ipAddress, username, password) -> State.Success
			else                                                      -> {
				val message = "Wrong username or password"
				State.Fail(AuthenticationException(message))
			}
		}
	}
	
}