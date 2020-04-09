package de.abacuselectronics.aroiorc.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.abacuselectronics.aroiorc.R

class DetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    if (savedInstanceState != null) return
  }

}