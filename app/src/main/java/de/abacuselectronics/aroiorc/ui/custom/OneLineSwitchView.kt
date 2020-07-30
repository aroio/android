package de.abacuselectronics.aroiorc.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.google.android.material.switchmaterial.SwitchMaterial
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.extensions.textAppearance
import de.abacuselectronics.aroiorc.ui.custom.divider.DividerFactory
import de.abacuselectronics.aroiorc.ui.custom.divider.DividerType

class OneLineSwitchView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

  /**
   * Listener for handling callbacks of the [OneLineSwitchView].
   * */
  interface CheckListener {

    /**
     * Listening to check event of [SwitchMaterial] within [OneLineSwitchView].
     * */
    fun onCheckedListener(oneLineSwitchView: OneLineSwitchView, isChecked: Boolean)

  }

  private var checkListener: CheckListener? = null

  private val dividerId = View.generateViewId()
  private val label: AppCompatTextView = AppCompatTextView(context, attrs)
  private val switch: SwitchMaterial = SwitchMaterial(context, attrs)

  private lateinit var dividerType: DividerType

  init {
    label.id = View.generateViewId()
    label.textAppearance(R.style.TextAppearance_Aroio_Body1)
    label.setTextColor(ContextCompat.getColor(context, R.color.black_500))
    label.layoutParams = LayoutParams(
      LayoutParams.MATCH_CONSTRAINT,
      LayoutParams.WRAP_CONTENT
    )

    switch.id = View.generateViewId()
    switch.layoutParams = LayoutParams(
      LayoutParams.WRAP_CONTENT,
      LayoutParams.WRAP_CONTENT
    )
    switch.setOnCheckedChangeListener { _, isChecked ->
      checkListener?.onCheckedListener(this, isChecked)
    }

    context.withStyledAttributes(attrs, R.styleable.OneLineSwitchView) {
      switch.isChecked =
        getBoolean(R.styleable.OneLineSwitchView_android_checked, false)
      label.text = getText(R.styleable.OneLineSwitchView_label)
      dividerType = DividerType.values()[getInt(
        R.styleable.OneLineSwitchView_indent_type,
        0
      )]
    }

    addView(label)
    addView(switch)
    DividerFactory.getDivider(context, dividerType)?.let {
      it.id = dividerId
      addView(it)
    }

    setConstraints()
  }

  /**
   * @param checkListener for the check event of the toggle.
   * */
  @Suppress("UNUSED")
  fun setCheckedListener(checkListener: CheckListener) {
    this.checkListener = checkListener
  }

  /**
   * @see setCheckedListener
   * @param onCheck callback handling the check event.
   * */
  @Suppress("UNUSED")
  fun setCheckedListener(onCheck: (isChecked: Boolean) -> Unit) {
    this.checkListener = object : CheckListener {
      override fun onCheckedListener(
        oneLineSwitchView: OneLineSwitchView,
        isChecked: Boolean
      ) {
        onCheck.invoke(isChecked)
      }

    }
  }


  private fun setConstraints() {
    val defaultMargin =
      context.resources.getDimension(R.dimen.default_space).toInt()
    ConstraintSet().apply {
      clone(this@OneLineSwitchView)
      connect(switch.id, TOP, PARENT_ID, TOP)
      connect(
        switch.id,
        END,
        PARENT_ID,
        END,
        defaultMargin
      )
      connect(switch.id, BOTTOM, PARENT_ID, BOTTOM)

      connect(
        label.id,
        START,
        PARENT_ID,
        START,
        defaultMargin
      )
      connect(label.id, TOP, switch.id, TOP)
      connect(
        label.id,
        END,
        switch.id,
        START,
        context.resources.getDimension(R.dimen.default_space_0_5).toInt()
      )
      connect(label.id, BOTTOM, switch.id, BOTTOM)

      if (dividerType == DividerType.NONE || !::dividerType.isInitialized) return@apply
      val marginStart =
        if (dividerType == DividerType.INDENT) defaultMargin
        else 0

      connect(dividerId, START, PARENT_ID, START, marginStart)
      connect(dividerId, END, PARENT_ID, END)
      connect(dividerId, BOTTOM, PARENT_ID, BOTTOM)
    }.applyTo(this)
  }
}