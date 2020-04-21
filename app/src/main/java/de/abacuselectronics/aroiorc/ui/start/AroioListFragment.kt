package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.view.View
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerFragment
import de.abacuselectronics.aroiorc.ui.recycler.items.AroioListItem
import de.abacuselectronics.aroiorc.ui.recycler.items.Margin
import de.abacuselectronics.aroiorc.ui.recycler.items.OverlineItem
import de.abacuselectronics.aroiorc.ui.recycler.items.TitleBodyCardItem

class AroioListFragment : RecyclerFragment() {

  interface Listener {
    fun onListAroioClicked(aroioIpAddress: String)
  }

  var listener: Listener? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val titleBodyCardItem = TitleBodyCardItem(
      title = R.string.information,
      body = R.string.information_body,
      margin = Margin(16, 24, 16, 0)
    )

    val overline = OverlineItem(
      text = R.string.accessible_devices,
      margin = Margin(0, 24, 0, 0)
    )

    val aroio = AroioListItem(
      ipAddress = "192.168.1.53",
      name = "Hermanns",
      onClick = { listener?.onListAroioClicked("192.168.1.53") }
    )

    // Setting RecyclerItems
    setItems(listOf(titleBodyCardItem, overline, aroio, aroio))
  }

  companion object {
    fun newInstance() = AroioListFragment()
  }

}