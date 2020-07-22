package de.abacuselectronics.aroiorc.extensions

import android.view.ViewGroup
import androidx.core.view.updateMarginsRelative
import de.abacuselectronics.aroiorc.ui.recycler.items.Margin

fun ViewGroup.MarginLayoutParams.updateMarginsRelative(margin: Margin) {
  this.updateMarginsRelative(
    start = margin.start,
    top = margin.top,
    end = margin.end,
    bottom = margin.bottom
  )
}