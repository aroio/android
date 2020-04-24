package de.abacuselectronics.aroiorc.aroioktx

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.M
import android.widget.TextView
import androidx.annotation.StyleRes

@Suppress("DEPRECATION")
fun TextView.textAppearance(@StyleRes style: Int) {
  if (SDK_INT >= M) setTextAppearance(style)
  else setTextAppearance(this.context, style)
}