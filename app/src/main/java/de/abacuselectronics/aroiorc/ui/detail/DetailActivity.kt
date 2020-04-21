package de.abacuselectronics.aroiorc.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import de.abacuselectronics.aroiorc.R

class DetailActivity : AppCompatActivity() {

  private lateinit var viewPager: ViewPager2

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    viewPager = findViewById(R.id.detail_viewPager)
    viewPager.adapter = DetailFragmentPagerAdapter(this)
  }

}