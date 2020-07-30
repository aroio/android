package de.abacuselectronics.aroiorc.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.viewmodel.ViewModelFactory

class AroioListFragment : Fragment(R.layout.fragment_recycler) {
	
	interface Listener {
		fun onListAroioClicked(aroioIpAddress: String)
	}
	
	private val adapter = AroioListAdapter()
	private lateinit var recyclerView: RecyclerView
	private val viewModel: AroioListViewModel by viewModels {
		ViewModelFactory(requireContext())
	}
	
	var listener: Listener? = null
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		recyclerView = view.findViewById(R.id.recycler)
		recyclerView.adapter = adapter
		recyclerView.layoutManager = LinearLayoutManager(view.context)
		viewModel.aroioList.observe(
			viewLifecycleOwner,
			Observer { adapter.setAroios(it) })
	}
	
	companion object {
		fun newInstance() = AroioListFragment()
	}
	
}