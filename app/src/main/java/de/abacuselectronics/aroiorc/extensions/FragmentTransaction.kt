package de.abacuselectronics.aroiorc.extensions

import androidx.fragment.app.FragmentTransaction
import de.abacuselectronics.aroiorc.R

fun FragmentTransaction.setDefaultAnimations(
  enter: Int = R.anim.enter_from_right,
  exit: Int = R.anim.exit_to_left,
  popEnter: Int = R.anim.enter_from_left,
  popExit: Int = R.anim.exit_to_right
) = this.setCustomAnimations(enter, exit, popEnter, popExit)
