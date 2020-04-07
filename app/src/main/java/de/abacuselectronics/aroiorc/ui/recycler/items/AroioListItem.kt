package de.abacuselectronics.aroiorc.ui.recycler.items

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerItem

class AroioListItem(
  private val ipAddress: String,
  private val name: String,
  private val onClick: ((String) -> Unit)?
) : RecyclerItem {

  override val layoutRes: Int
    get() = R.layout.recycleritem_aroio_list

  override fun bind(holder: RecyclerView.ViewHolder) {
    require(holder is Holder)

    holder.ipAddress.text = ipAddress
    holder.name.text = name
    onClick?.let { lambda ->
      holder.view.setOnClickListener { lambda.invoke(ipAddress) }
    }
  }

  override fun createViewHolder(itemView: View): RecyclerView.ViewHolder {
    return Holder(itemView)
  }

  class Holder(val view: View) : RecyclerView.ViewHolder(view) {
    val ipAddress: AppCompatTextView =
      view.findViewById(R.id.aroio_list_ip_address)
    val name: AppCompatTextView = view.findViewById(R.id.aroio_list_name)
  }
}