package de.abacuselectronics.aroiorc.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

  override fun getItemCount(): Int = 4

  override fun createFragment(position: Int): Fragment {
    return when (position) {
      0 -> TODO("create ConfigurationFragment")
      1 -> TODO("create SystemFragment")
      2 -> TODO("create ConvolverFragment")
      3 -> TODO("create AudioFragment")
      else -> throw IllegalArgumentException("Only 4 fragments are implemented")
    }
  }

}