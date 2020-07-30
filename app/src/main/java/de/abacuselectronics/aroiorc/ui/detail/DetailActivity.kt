package de.abacuselectronics.aroiorc.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.detail.config.ConfigFragment
import de.abacuselectronics.aroiorc.ui.detail.system.SystemFragment

class DetailActivity : AppCompatActivity(),
	BottomNavigationView.OnNavigationItemSelectedListener {
	
	private lateinit var viewPager: ViewPager2
	private lateinit var bottomNav: BottomNavigationView
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)
		
		viewPager = findViewById(R.id.detail_viewPager)
		viewPager.isUserInputEnabled = false
		viewPager.adapter = DetailFragmentPagerAdapter(
			activity = this,
			fragments = listOf(
				ConfigFragment.newInstance(),
				SystemFragment.newInstance()
			)
		)
		
		bottomNav = findViewById(R.id.detail_bottom_navigation)
		bottomNav.setOnNavigationItemSelectedListener(this)
	}
	
	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.menu_detail_nav_config    -> viewPager.currentItem = 0
			R.id.menu_detail_nav_system    -> viewPager.currentItem = 1
			R.id.menu_detail_nav_convolver -> viewPager.currentItem = 2
			R.id.menu_detail_nav_audio     -> viewPager.currentItem = 3
			else                           -> return false
		}
		return true
	}
	
	private fun requireBaseAddress() = intent.extras?.getString(KEY_BASE_ADDRESS)
		?: throw IllegalStateException("Base IP address is required for the DetailActivity")
	
	
	companion object {
		private const val KEY_BASE_ADDRESS =
			"de.abacuselectronics.aroiorc.ui.detail.base_address"
		
		fun createIntent(context: Context, ipAddress: String): Intent =
			Intent(context, DetailActivity::class.java).apply {
				putExtra(KEY_BASE_ADDRESS, ipAddress)
			}
	}
}