package de.abacuselectronics.aroiorc.ui.custom.divider

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import de.abacuselectronics.aroiorc.R

object DividerFactory {
	
	fun getDivider(context: Context, dividerType: DividerType): View? =
		when (dividerType) {
			DividerType.INDENT -> createDivider(
				context = context,
				margin = context.resources.getDimension(R.dimen.divider).toInt()
			)
			DividerType.FULL   -> createDivider(
				context = context,
				margin = 0
			)
			DividerType.NONE   -> null
		}
	
	private fun createDivider(context: Context, margin: Int): View {
		val divider = View(context)
		// loading height of 1dp from resources
		divider.layoutParams = ViewGroup.MarginLayoutParams(
			ViewGroup.LayoutParams.MATCH_PARENT,
			context.resources.getDimension(R.dimen.divider).toInt()
		).apply { marginStart = margin }
		// color of divider
		divider.background = ContextCompat.getDrawable(context, R.color.black_200)
		
		return divider
	}
	
}