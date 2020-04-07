package de.abacuselectronics.aroiorc.ui.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


interface RecyclerItem {
  @get:LayoutRes
  val layoutRes: Int
  fun bind()
}


abstract class GenericRecyclerViewAdapter :
  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  var items: List<RecyclerItem> = emptyList()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): RecyclerView.ViewHolder {
    TODO("not implemented")
  }

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(
    holder: RecyclerView.ViewHolder,
    position: Int
  ) {
    TODO("not implemented")
  }
}