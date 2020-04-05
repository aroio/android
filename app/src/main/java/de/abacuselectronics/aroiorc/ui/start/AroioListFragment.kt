package de.abacuselectronics.aroiorc.ui.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R

class AroioListFragment : Fragment(R.layout.fragment_start) {

  private lateinit var recyclerView: RecyclerView

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    recyclerView = view.findViewById(R.id.start_recycler)
    recyclerView.layoutManager = LinearLayoutManager(requireContext())
  }

}