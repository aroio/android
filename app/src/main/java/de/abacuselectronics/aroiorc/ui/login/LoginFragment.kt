package de.abacuselectronics.aroiorc.ui.login

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import de.abacuselectronics.aroiorc.R

class LoginFragment : Fragment(R.layout.fragment_login) {

	private lateinit var usernameTextView: TextInputEditText
	private lateinit var passwordTextView: TextInputEditText
	private lateinit var button: MaterialButton
	private lateinit var progress: ProgressBar

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		usernameTextView = view.findViewById(R.id.username_edit_text)
		passwordTextView = view.findViewById(R.id.password_edit_text)
		progress = view.findViewById(R.id.progress)
		button = view.findViewById(R.id.login_button)

		view.findViewById<MaterialButton>(R.id.cancel_button)
			.setOnClickListener { parentFragmentManager.popBackStack() }
	}

	companion object {
		private const val KEY_AROIO_IP_ADDRESS =
			"de.abacuselectronics.aroiorc.ui.start.aroio_name"

		fun newInstance(aroioName: String): LoginFragment {
			val bundle = Bundle()
			bundle.putString(KEY_AROIO_IP_ADDRESS, aroioName)
			return LoginFragment()
				.apply { arguments = bundle }
		}
	}
}