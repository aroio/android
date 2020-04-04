package de.abacuselectronics.aroiorc.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.abacuselectronics.aroiorc.R

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.container, MainFragment.newInstance())
        .commitNow()
    }
  }
}
