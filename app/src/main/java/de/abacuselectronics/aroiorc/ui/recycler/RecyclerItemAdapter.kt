package de.abacuselectronics.aroiorc.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView.Adapter for [RecyclerItem] objects.
 * @see RecyclerItem
 * */
class RecyclerItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  /**
   * Store of RecyclerItems to be displayed.
   * */
  var items: List<RecyclerItem> = emptyList()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val view = inflater.inflate(viewType, parent, false)

    // NOTE:  The viewType is defined by the layoutRes in getItemViewType().
    return items.first { it.layoutRes == viewType }.createViewHolder(view)
  }

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(
    holder: RecyclerView.ViewHolder,
    position: Int
  ) {
    items[position].bind(holder)
  }

  override fun getItemViewType(position: Int): Int {
    // NOTE:  Use the layoutRes of a RecyclerItem as the viewType to create
    //        correct ViewHolder in onCreateViewHolder().
    return items[position].layoutRes
  }
}