package de.abacuselectronics.aroiorc.ui.detail.config

import android.os.Bundle
import android.view.View
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerFragment
import de.abacuselectronics.aroiorc.ui.recycler.items.Margin
import de.abacuselectronics.aroiorc.ui.recycler.items.OverlineItem
import de.abacuselectronics.aroiorc.ui.recycler.items.TextSwitchItem
import de.abacuselectronics.aroiorc.ui.recycler.items.TextType

class ConfigFragment : RecyclerFragment() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val networkOverline = OverlineItem(
      textType = TextType.Res(R.string.detail_config_overline_network),
      margin = Margin(start = 0, top = 24, end = 0, bottom = 0)
    )
    val wlanTextSwitch = TextSwitchItem(
      textType = TextType.Res(R.string.detail_config_wlan),
      toggleState = false
    )
    val automaticConfigTextSwitch = TextSwitchItem(
      textType = TextType.Res(R.string.detail_config_automatic_config),
      toggleState = true
    )

    setItems(listOf(networkOverline, wlanTextSwitch, automaticConfigTextSwitch))
  }


  companion object {
    fun newInstance() = ConfigFragment()
  }
}