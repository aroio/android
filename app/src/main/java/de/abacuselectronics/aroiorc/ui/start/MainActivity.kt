package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.aroioktx.setDefaultAnimations

class MainActivity : AppCompatActivity(),
  LoginFragment.Listener,
  AroioListFragment.Listener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.container, AroioListFragment.newInstance())
        .commitNow()
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
    Toast.makeText(this, "$username and $password", Toast.LENGTH_SHORT).show()
  }

  override fun onListAroioClicked(aroioIpAddress: String) {
    supportFragmentManager.beginTransaction()
      .setDefaultAnimations()
      .replace(R.id.container, LoginFragment.newInstance(aroioIpAddress))
      .addToBackStack(null)
      .commit()
  }
}
