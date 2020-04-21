package de.abacuselectronics.aroiorc.ui.recycler.items

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.recycler.RecyclerItem

class TextSwitchItem(
  private val textType: TextType,
  private val toggleState: Boolean
) : RecyclerItem {

  override val layoutRes: Int
    get() = R.layout.recycleritem_text_switch

  override fun bind(holder: RecyclerView.ViewHolder) {
    require(holder is Holder)
    when (textType) {
      is TextType.Res -> holder.text.setText(textType.id)
      is TextType.Raw -> holder.text.text = textType.value
    }
    holder.switch.isChecked = toggleState
  }

  override fun createViewHolder(itemView: View): RecyclerView.ViewHolder =
    Holder(itemView)

  class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text: AppCompatTextView =
      itemView.findViewById(R.id.recycleritem_text_switch_text)
    val switch: SwitchMaterial =
      itemView.findViewById(R.id.recycleritem_text_switch_switch)
  }

}