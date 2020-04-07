package de.abacuselectronics.aroiorc.ui.recycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R

abstract class RecyclerFragment : Fragment(R.layout.fragment_recycler) {

  protected lateinit var recyclerView: RecyclerView

  abstract val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView = view.findViewById(R.id.recycler)
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(view.context)
    recyclerView.adapter = adapter
  }
}