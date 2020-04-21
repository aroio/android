package de.abacuselectronics.aroiorc.ui.recycler.items

import androidx.annotation.StringRes

sealed class TextType {
  class Res(@StringRes val id: Int) : TextType()
  class Raw(val value: String) : TextType()
}