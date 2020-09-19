package de.abacuselectronics.aroiorc.ui.login

import androidx.lifecycle.*
import de.abacus.aroio.network.OAuthTokenProvider
import de.abacus.aroio.network.service.AuthenticationService
import de.abacuselectronics.aroiorc.repository.AuthRepository
import de.abacuselectronics.aroiorc.repository.AuthRepositoryImpl
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginViewModel(
	private val authRepository: AuthRepository
) : ViewModel() {
	
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
		authRepository.authenticate(username, password)
		return State.Success
	}
}

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(
	private val oAuthTokenProvider: OAuthTokenProvider,
	private val ipAddress: String
) : ViewModelProvider.Factory {
	
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		val service = AuthenticationService.get(oAuthTokenProvider, ipAddress)
		val repo = AuthRepositoryImpl(oAuthTokenProvider, service)
		return LoginViewModel(repo) as T
	}
}