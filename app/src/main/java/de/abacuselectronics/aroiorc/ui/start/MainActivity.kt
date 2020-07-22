package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.extensions.setDefaultAnimations
import de.abacuselectronics.aroiorc.ui.detail.DetailActivity
import de.abacuselectronics.aroiorc.viewmodel.start.StartViewModel

class MainActivity : AppCompatActivity(),
	LoginFragment.Listener,
	AroioListFragment.Listener {
	
	private val viewModel: StartViewModel by viewModels()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)
		
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
				.replace(R.id.container, AroioListFragment.newInstance())
				.commitNow()
		}
		
		viewModel.state.observe(this) { state ->
			when (state) {
				StartViewModel.State.Loading -> showProgress()
				StartViewModel.State.Success -> startDetailActivity()
				is StartViewModel.State.Fail -> displayFailure(state.exception)
			}
		}
	}
	
	override fun onAttachFragment(fragment: Fragment) {
		super.onAttachFragment(fragment)
		
		when (fragment) {
			is AroioListFragment -> fragment.listener = this
			is LoginFragment     -> fragment.listener = this
		}
	}
	
	override fun onCancel() {
		supportFragmentManager.popBackStack()
	}
	
	override fun onLogin(username: String, password: String) {
		viewModel.login(username, password)
	}
	
	override fun onListAroioClicked(aroioIpAddress: String) {
		viewModel.ipAddress = aroioIpAddress
		supportFragmentManager.beginTransaction()
			.setDefaultAnimations()
			.replace(R.id.container, LoginFragment.newInstance(aroioIpAddress))
			.addToBackStack(null)
			.commit()
	}
	
	private fun startDetailActivity() {
		startActivity(DetailActivity.createIntent(this))
	}
	
	private fun showProgress() {
		// TODO - show progress
		Log.i(javaClass.simpleName, "Show the progressbar")
	}
	
	private fun displayFailure(exception: Exception) {
		// TODO - display Failure
		Log.i(javaClass.simpleName, "Display the failure cause: $exception")
	}
	
}
