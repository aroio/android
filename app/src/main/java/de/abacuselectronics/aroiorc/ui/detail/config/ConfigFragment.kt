package de.abacuselectronics.aroiorc.ui.detail.config

import android.os.Bundle
import android.view.View
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerFragment
import de.abacuselectronics.aroiorc.ui.recycler.items.OverlineItem

class ConfigFragment : RecyclerFragment() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val networkOverline = OverlineItem(R.string.detail_config_overline_network)

    setItems(listOf(networkOverline))
  }


  companion object {
    fun newInstance() = ConfigFragment()
  }
}