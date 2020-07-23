package de.abacuselectronics.aroiorc.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerFragment
import de.abacuselectronics.aroiorc.ui.recycler.items.*
import de.abacuselectronics.aroiorc.viewmodel.ViewModelFactory

class AroioListFragment : RecyclerFragment() {
	
	interface Listener {
		fun onListAroioClicked(aroioIpAddress: String)
	}
	
	private val viewModel: AroioListViewModel by viewModels {
		ViewModelFactory(requireContext())
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
			textType = TextType.Res(R.string.accessible_devices),
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