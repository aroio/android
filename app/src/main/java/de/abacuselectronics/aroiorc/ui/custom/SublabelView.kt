package de.abacuselectronics.aroiorc.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.extensions.textAppearance
import de.abacuselectronics.aroiorc.ui.custom.divider.DividerType

class SublabelView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

  private val subtitle: AppCompatTextView
  private val label: AppCompatTextView

  private val marginStartEnd by lazy {
    resources.getDimension(R.dimen.default_space).toInt()
  }
  private val marginTopBottom by lazy {
    resources.getDimension(R.dimen.default_space_0_75).toInt()
  }


  init {
    orientation = VERTICAL

    label = AppCompatTextView(context)
    label.textAppearance(R.style.TextAppearance_Aroio_Subtitle1)
    label.setTextColor(ContextCompat.getColor(context, R.color.black_500))
    label.layoutParams = MarginLayoutParams(
      MarginLayoutParams.MATCH_PARENT,
      MarginLayoutParams.WRAP_CONTENT
    ).apply { setMargins(marginStartEnd, marginTopBottom, marginStartEnd, 0) }

    subtitle = AppCompatTextView(context)
    subtitle.textAppearance(R.style.TextAppearance_Aroio_Body2)
    subtitle.setTextColor(ContextCompat.getColor(context, R.color.black_400))
    subtitle.layoutParams = MarginLayoutParams(
      MarginLayoutParams.MATCH_PARENT,
      MarginLayoutParams.WRAP_CONTENT
    ).apply { setMargins(marginStartEnd, 0, marginStartEnd, marginTopBottom) }

    var dividerType: DividerType = DividerType.NONE
    context.withStyledAttributes(attrs, R.styleable.SublabelView) {
      label.text = getText(R.styleable.SublabelView_label)
      subtitle.text = getText(R.styleable.SublabelView_subtitle)
      dividerType =
        DividerType.values()[getInt(R.styleable.SublabelView_indent_type, 0)]
    }

    addView(label)
    addView(subtitle)
    getDivider(dividerType)?.let { addView(it) }
  }

  fun setLabel(label: String) {
    this.label.text = label
    invalidate()
  }

  private fun getDivider(dividerType: DividerType): View? = when (dividerType) {
    DividerType.INDENT -> createDivider(marginStartEnd)
    DividerType.FULL   -> createDivider(0)
    DividerType.NONE   -> null
  }

  private fun createDivider(margin: Int): View {
    val divider = View(context)
    divider.layoutParams = MarginLayoutParams(
      MarginLayoutParams.MATCH_PARENT,
      resources.getDimension(R.dimen.divider).toInt()
    ).apply { setMargins(margin, 0, 0, 0) }
    divider.background = ContextCompat.getDrawable(context, R.color.black_200)
    return divider
  }

}