package de.abacuselectronics.aroiorc.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailFragmentPagerAdapter(
  activity: FragmentActivity,
  private val fragments: List<Fragment>
) : FragmentStateAdapter(activity) {

  override fun getItemCount(): Int = fragments.size

  override fun createFragment(position: Int): Fragment = fragments[position]

}