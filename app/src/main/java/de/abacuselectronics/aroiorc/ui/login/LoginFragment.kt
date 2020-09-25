package de.abacuselectronics.aroiorc.ui.login

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import de.abacus.aroio.network.auth.OAuthTokenProvider
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.detail.DetailActivity

class LoginFragment : Fragment(R.layout.fragment_login) {
	
	private lateinit var usernameTextView: TextInputEditText
	private lateinit var passwordTextView: TextInputEditText
	private lateinit var button: MaterialButton
	private lateinit var progress: ProgressBar
	
	private val viewModel: LoginViewModel by viewModels {
		val tokenProvider = OAuthTokenProvider.create(requireContext())
		LoginViewModelFactory(
			oAuthTokenProvider = tokenProvider,
			ipAddress = requireIpAddress()
		)
	}
	
	private val stateObserver = Observer<LoginViewModel.State> { state ->
		if (state != LoginViewModel.State.Loading) hideLoading()
		
		when (state) {
			LoginViewModel.State.Loading -> showLoading()
			LoginViewModel.State.Success -> loggedInSuccessfully()
			is LoginViewModel.State.Failure -> showError(state.reason)
		}
	}
	
	private fun showError(reason: LoginViewModel.FailReason) {
		val message = when (reason) {
			LoginViewModel.FailReason.InvalidInput -> "Invalid input text"
			LoginViewModel.FailReason.AuthenticationFailed -> "Wrong username or password"
		}
		Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
	}
	
	private fun loggedInSuccessfully() {
		val intent = DetailActivity.createIntent(
			context = requireContext(),
			ipAddress = requireIpAddress()
		)
		startActivity(intent)
		parentFragmentManager.popBackStack()
	}
	
	private fun showLoading() {
		button.visibility = View.INVISIBLE
		progress.visibility = View.VISIBLE
	}
	
	private fun hideLoading() {
		button.visibility = View.VISIBLE
		progress.visibility = View.INVISIBLE
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		usernameTextView = view.findViewById(R.id.username_edit_text)
		passwordTextView = view.findViewById(R.id.password_edit_text)
		progress = view.findViewById(R.id.progress)
		button = view.findViewById(R.id.login_button)
		button.setOnClickListener {
			viewModel.login(
				username = usernameTextView.text.toString(),
				password = passwordTextView.text.toString()
			)
		}
		
		view.findViewById<MaterialButton>(R.id.cancel_button)
			.setOnClickListener { parentFragmentManager.popBackStack() }
	}
	
	override fun onResume() {
		super.onResume()
		viewModel.state.observe(viewLifecycleOwner, stateObserver)
	}
	
	private fun requireIpAddress() =
		requireArguments().getString(KEY_AROIO_IP_ADDRESS)
			?: throw IllegalStateException("IP Address is required t use the LoginFragment")
	
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