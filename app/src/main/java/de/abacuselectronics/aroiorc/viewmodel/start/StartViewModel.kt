package de.abacuselectronics.aroiorc.viewmodel.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class StartViewModel : ViewModel() {

  enum class State { LOADING, SUCCESS, FAIL }

  lateinit var ipAddress: String

  private val _state = MutableLiveData<State>()
  val state: LiveData<State> = _state

  suspend fun login(username: String, password: String) = withContext(IO) {
    if (::ipAddress.isInitialized) {
      _state.postValue(State.LOADING)
    } else {
      _state.postValue(State.FAIL)
      return@withContext
    }

    tryLogin(username, password, ipAddress)
  }

  private suspend fun tryLogin(
    username: String,
    password: String,
    ipAddress: String
  ) {
    // TODO - Implement the login process. Currently only set state to success
    //        for debugging purposes.
    _state.postValue(State.SUCCESS)
  }

}