package de.abacuselectronics.aroiorc.ui.recycler.items

import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.aroioktx.updateMarginsRelative
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerItem


class TitleBodyCardItem(
  @StringRes private val title: Int,
  @StringRes private val body: Int,
  private val margin: Margin = Margin(16, 12, 16, 12)
) : RecyclerItem {

  override val layoutRes: Int
    get() = R.layout.recycleritem_title_body_card

  override fun bind(holder: RecyclerView.ViewHolder) {
    require(holder is Holder)
    holder.title.setText(title)
    holder.body.setText(body)
  }

  override fun createViewHolder(itemView: View): RecyclerView.ViewHolder {
    require(itemView is CardView)

    (itemView.layoutParams as ViewGroup.MarginLayoutParams)
      .updateMarginsRelative(margin = margin)

    return Holder(cardView = itemView)
  }

  class Holder(cardView: CardView) : RecyclerView.ViewHolder(cardView) {
    val title: AppCompatTextView =
      itemView.findViewById(R.id.title_body_card_title)
    val body: AppCompatTextView =
      itemView.findViewById(R.id.title_body_card_body)
  }
}