package de.abacuselectronics.aroiorc.aroioktx

import android.content.Context
import android.util.DisplayMetrics

fun Float.dpToPx(context: Context): Float {
  return this * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}

fun Float.pxToDp(context: Context): Float {
  return this.dpToPx(context)
}

