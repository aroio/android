package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import de.abacuselectronics.aroiorc.R

class LoginFragment : Fragment(R.layout.fragment_login) {

  private lateinit var usernameTextView: TextInputEditText
  private lateinit var passwordTextView: TextInputEditText
  private lateinit var loginButton: MaterialButton

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    usernameTextView = view.findViewById(R.id.username_edit_text)
    passwordTextView = view.findViewById(R.id.password_edit_text)
    loginButton = view.findViewById(R.id.login_button)
    loginButton.setOnClickListener { login() }
  }

  private fun login() {
    TODO("use username and password to login")
  }

}