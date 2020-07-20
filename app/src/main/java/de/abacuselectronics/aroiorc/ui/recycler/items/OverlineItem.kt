package de.abacuselectronics.aroiorc.ui.recycler.items

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.extensions.updateMarginsRelative
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerItem

class OverlineItem(
  private val textType: TextType,
  private val margin: Margin = Margin(0, 0, 0, 0)
) : RecyclerItem {

  override val layoutRes: Int
    get() = R.layout.recycleritem_overline

  override fun bind(holder: RecyclerView.ViewHolder) {
    require(holder is Holder)
    when (textType) {
      is TextType.Res -> holder.overline.setText(textType.id)
      is TextType.Raw -> holder.overline.text = textType.value
    }

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