package de.abacuselectronics.aroiorc.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.databinding.FragmentAroioListBinding
import de.abacuselectronics.aroiorc.viewmodel.AroioListViewModel
import de.abacuselectronics.aroiorc.viewmodel.AroioListViewModelFactory

class AroioListFragment : Fragment(R.layout.fragment_aroio_list) {
	
	interface Listener {
		fun onListAroioClicked(aroioIpAddress: String)
	}
	
	private lateinit var binding: FragmentAroioListBinding
	private val adapter = AroioListAdapter {
		listener?.onListAroioClicked(it.ipAddress)
	}
	
	private val viewModel: AroioListViewModel by viewModels {
		AroioListViewModelFactory(requireContext())
	}
	private val stateObserver = Observer<AroioListViewModel.State> { state ->
		when (state) {
			AroioListViewModel.State.NoDevicesFound      -> displayNoDevicesFound()
			is AroioListViewModel.State.DevicesAvailable -> displayFoundDevices(
				state.aroioList
			)
		}
	}
	
	var listener: Listener? = null
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		binding = FragmentAroioListBinding.bind(view)
		binding.recycler.adapter = adapter
		viewModel.state.observe(viewLifecycleOwner, stateObserver)
	}
	
	private fun displayFoundDevices(aroioList: List<de.abacus.aroio.database.entities.Aroio>) {
		binding.recycler.visibility = View.VISIBLE
		binding.fallbackView.visibility = View.GONE
		adapter.setAroioList(aroioList)
	}
	
	private fun displayNoDevicesFound() {
		binding.recycler.visibility = View.GONE
		binding.fallbackView.visibility = View.VISIBLE
	}
	
	companion object {
		fun newInstance() = AroioListFragment()
	}
	
}