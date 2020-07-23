package de.abacuselectronics.aroiorc.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.viewmodel.ViewModelFactory

class LoginFragment : Fragment(R.layout.fragment_login) {
	
	interface Listener {
		fun onCancel()
	}
	
	private lateinit var usernameTextView: TextInputEditText
	private lateinit var passwordTextView: TextInputEditText
	
	private val viewModel: LoginViewModel by viewModels {
		val ipAddress = requireArguments().getString(KEY_AROIO_IP_ADDRESS)
		ViewModelFactory(ipAddress = ipAddress)
	}
	
	var listener: Listener? = null
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		usernameTextView = view.findViewById(R.id.username_edit_text)
		passwordTextView = view.findViewById(R.id.password_edit_text)
		view.findViewById<MaterialButton>(R.id.login_button)
			.setOnClickListener {
				login(
					usernameTextView.text.toString(),
					passwordTextView.text.toString()
				)
			}
		view.findViewById<MaterialButton>(R.id.cancel_button).setOnClickListener { listener?.onCancel() }
	}
	
	private fun login(username: String, password: String) {
    viewModel.login(username = username, password = password)
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