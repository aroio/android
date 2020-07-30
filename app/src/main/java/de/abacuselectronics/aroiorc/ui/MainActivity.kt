package de.abacuselectronics.aroiorc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.extensions.setDefaultAnimations
import de.abacuselectronics.aroiorc.ui.list.AroioListFragment
import de.abacuselectronics.aroiorc.ui.list.LoginFragment

class MainActivity : AppCompatActivity(), AroioListFragment.Listener {
	
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
		}
	}
	
	override fun onListAroioClicked(aroioIpAddress: String) {
		supportFragmentManager.beginTransaction()
			.setDefaultAnimations()
			.replace(R.id.container, LoginFragment.newInstance(aroioIpAddress))
			.addToBackStack(null)
			.commit()
	}
	
}
