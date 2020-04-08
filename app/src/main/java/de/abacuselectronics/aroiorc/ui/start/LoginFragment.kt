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
    fun onCancel()
  }

  private lateinit var usernameTextView: TextInputEditText
  private lateinit var passwordTextView: TextInputEditText

  var listener: Listener? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    usernameTextView = view.findViewById(R.id.username_edit_text)
    passwordTextView = view.findViewById(R.id.password_edit_text)
    view.findViewById<MaterialButton>(R.id.login_button)
      .setOnClickListener { login() }
    view.findViewById<MaterialButton>(R.id.cancel_button)
      .setOnClickListener { listener?.onCancel() }
    requireActivity().title = requireArguments().getString(KEY_AROIO_IP_ADDRESS)
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
    private const val KEY_AROIO_IP_ADDRESS =
      "de.abacuselectronics.aroiorc.ui.start.aroio_name"

    fun newInstance(aroioName: String): LoginFragment {
      val fragment = LoginFragment()
      fragment.arguments = Bundle().apply {
        putString(KEY_AROIO_IP_ADDRESS, aroioName)
      }
      return fragment
    }
  }
}