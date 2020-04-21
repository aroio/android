package de.abacuselectronics.aroiorc.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.start.AroioListFragment

class DetailActivity : AppCompatActivity(),
  BottomNavigationView.OnNavigationItemSelectedListener {

  private lateinit var viewPager: ViewPager2
  private lateinit var bottomNav: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    viewPager = findViewById(R.id.detail_viewPager)
    viewPager.adapter = DetailFragmentPagerAdapter(
      activity = this,
      fragments = listOf(AroioListFragment.newInstance())
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
    }
    return true
  }

  companion object {
    fun createIntent(context: Context): Intent =
      Intent(context, DetailActivity::class.java)
  }
}