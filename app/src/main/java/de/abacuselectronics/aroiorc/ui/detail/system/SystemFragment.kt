package de.abacuselectronics.aroiorc.ui.detail.system

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.custom.OneLineSwitchView
import de.abacuselectronics.aroiorc.ui.custom.SublabelView

class SystemFragment : Fragment(R.layout.fragment_detail_system) {

  private lateinit var nameSublabelView: SublabelView
  private lateinit var runningSublabelView: SublabelView
  private lateinit var macCableSublabelView: SublabelView
  private lateinit var macWlanSublabelView: SublabelView
  private lateinit var ipCableSublabelView: SublabelView
  private lateinit var ipWlanSublabelView: SublabelView
  private lateinit var squeezeServerSublabelView: SublabelView

  private lateinit var betaSwitch: OneLineSwitchView
  private lateinit var updateButton: MaterialButton


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    nameSublabelView = view.findViewById(R.id.detail_system_name)
    nameSublabelView.setLabel("-")
    runningSublabelView = view.findViewById(R.id.detail_system_running_since)
    runningSublabelView.setLabel("-")
    macCableSublabelView =
      view.findViewById(R.id.detail_system_mac_address_cable)
    macCableSublabelView.setLabel("-")
    macWlanSublabelView = view.findViewById(R.id.detail_system_mac_address_wlan)
    macWlanSublabelView.setLabel("-")
    ipCableSublabelView = view.findViewById(R.id.detail_system_ip_address_cable)
    ipCableSublabelView.setLabel("-")
    ipWlanSublabelView = view.findViewById(R.id.detail_system_ip_address_wlan)
    ipWlanSublabelView.setLabel("-")
    squeezeServerSublabelView = view.findViewById(R.id.detail_system_squeeze)
    squeezeServerSublabelView.setLabel("-")

    updateButton = view.findViewById(R.id.detail_system_start_update_button)
    updateButton.setOnClickListener { startUpdate() }

    betaSwitch = view.findViewById(R.id.detail_system_use_beta)
    betaSwitch.setCheckedListener { updateSwitch(it) }
  }

  private fun updateSwitch(isChecked: Boolean) {
    Toast.makeText(
      requireContext(),
      "is it checked? $isChecked",
      Toast.LENGTH_SHORT
    ).show()
  }

  private fun startUpdate() {
    Toast.makeText(
      requireContext(),
      "Search for updates",
      Toast.LENGTH_SHORT
    ).show()
  }

  companion object {
    fun newInstance() = SystemFragment()
  }

}