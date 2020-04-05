package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import de.abacuselectronics.aroiorc.R

class LoginFragment : Fragment(R.layout.fragment_login) {

  interface Listener {
    fun onLogin(username: String, password: String)
  }

  private lateinit var usernameTextView: TextInputEditText
  private lateinit var passwordTextView: TextInputEditText
  private lateinit var loginButton: MaterialButton

  var listener: Listener? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    usernameTextView = view.findViewById(R.id.username_edit_text)
    passwordTextView = view.findViewById(R.id.password_edit_text)
    loginButton = view.findViewById(R.id.login_button)
    loginButton.setOnClickListener { login() }
  }

  private fun login() {
    if (inputIsValid()) {
      listener?.onLogin(
        username = usernameTextView.text.toString(),
        password = passwordTextView.text.toString()
      )
    } else {
      Toast.makeText(requireContext(), "Input invalid", Toast.LENGTH_SHORT)
        .show()
    }
  }

  private fun inputIsValid(): Boolean {
    val usernameNullOrBlank = usernameTextView.text.isNullOrBlank()
    val passwordNullOrBlank = passwordTextView.text.isNullOrBlank()
    return !usernameNullOrBlank && !passwordNullOrBlank
  }

  companion object {
    fun newInstance() = LoginFragment()
  }
}