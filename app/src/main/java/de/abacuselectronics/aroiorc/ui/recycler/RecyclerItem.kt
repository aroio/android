package de.abacuselectronics.aroiorc.ui.recycler

import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


/**
 * Generic item for RecyclerView.
 * @see RecyclerItemAdapter
 * */
interface RecyclerItem {
  @get:LayoutRes
  val layoutRes: Int
  fun bind(holder: RecyclerView.ViewHolder)
  fun createViewHolder(itemView: View): RecyclerView.ViewHolder
}