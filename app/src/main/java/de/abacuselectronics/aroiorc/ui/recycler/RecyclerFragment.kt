package de.abacuselectronics.aroiorc.ui.recycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R

/**
 * Fragment with a single RecyclerView as content.
 * */
abstract class RecyclerFragment : Fragment(R.layout.fragment_recycler) {

  protected open lateinit var recyclerView: RecyclerView

  protected open var layoutManager: RecyclerView.LayoutManager? = null

  /**
   * [RecyclerView.Adapter] to use for the RecyclerView.
   * */
  abstract val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView = view.findViewById(R.id.recycler)
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = layoutManager
      ?: LinearLayoutManager(view.context)
    recyclerView.adapter = adapter
  }
}