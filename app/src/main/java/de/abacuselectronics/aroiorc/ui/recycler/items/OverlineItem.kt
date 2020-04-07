package de.abacuselectronics.aroiorc.ui.recycler.items

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.aroioktx.updateMarginsRelative
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerItem

class OverlineItem(
  @StringRes private val text: Int,
  private val margin: Margin = Margin(0, 0, 0, 0)
) : RecyclerItem {

  override val layoutRes: Int
    get() = R.layout.recycleritem_overline

  override fun bind(holder: RecyclerView.ViewHolder) {
    require(holder is Holder)
    holder.overline.setText(text)
  }

  override fun createViewHolder(itemView: View): RecyclerView.ViewHolder {
    require(itemView is LinearLayout)
    (itemView.layoutParams as ViewGroup.MarginLayoutParams)
      .updateMarginsRelative(margin)
    return Holder(itemView)
  }

  class Holder(view: View) : RecyclerView.ViewHolder(view) {
    val overline: AppCompatTextView = view.findViewById(R.id.overline)
  }
}