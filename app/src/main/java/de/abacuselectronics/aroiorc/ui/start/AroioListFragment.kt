package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.view.View
import android.widget.Toast
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerFragment
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerItemAdapter
import de.abacuselectronics.aroiorc.ui.recycler.items.AroioListItem
import de.abacuselectronics.aroiorc.ui.recycler.items.Margin
import de.abacuselectronics.aroiorc.ui.recycler.items.OverlineItem
import de.abacuselectronics.aroiorc.ui.recycler.items.TitleBodyCardItem

class AroioListFragment : RecyclerFragment() {

  override val adapter = RecyclerItemAdapter()

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
      onClick = {
        Toast.makeText(requireContext(), "Clicked $it", Toast.LENGTH_SHORT)
          .show()
      }
    )

    adapter.items = listOf(titleBodyCardItem, overline, aroio, aroio)
  }

  companion object {
    fun newInstance() = AroioListFragment()
  }

}