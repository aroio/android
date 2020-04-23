package de.abacuselectronics.aroiorc.ui.detail.system

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.ui.custom.SublabelView

class SystemFragment: Fragment(R.layout.fragment_detail_system) {

  private lateinit var nameSublabelView: SublabelView
  private lateinit var runningSublabelView: SublabelView
  private lateinit var macCableSublabelView: SublabelView
  private lateinit var macWlanSublabelView: SublabelView
  private lateinit var ipCableSublabelView: SublabelView
  private lateinit var ipWlanSublabelView: SublabelView
  private lateinit var squeezeServerSublabelView: SublabelView


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    nameSublabelView = view.findViewById(R.id.detail_system_name)
    nameSublabelView.setLabel("-")
    runningSublabelView = view.findViewById(R.id.detail_system_running_since)
    runningSublabelView.setLabel("-")
    macCableSublabelView = view.findViewById(R.id.detail_system_mac_address_cable)
    macCableSublabelView.setLabel("-")
    macWlanSublabelView = view.findViewById(R.id.detail_system_mac_address_wlan)
    macWlanSublabelView.setLabel("-")
    ipCableSublabelView = view.findViewById(R.id.detail_system_ip_address_cable)
    ipCableSublabelView.setLabel("-")
    ipWlanSublabelView = view.findViewById(R.id.detail_system_ip_address_wlan)
    ipWlanSublabelView.setLabel("-")
    squeezeServerSublabelView = view.findViewById(R.id.detail_system_squeeze)
    squeezeServerSublabelView.setLabel("-")
  }

  companion object {
    fun newInstance() = SystemFragment()
  }

}