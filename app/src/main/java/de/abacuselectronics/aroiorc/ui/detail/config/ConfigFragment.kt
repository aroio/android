package de.abacuselectronics.aroiorc.ui.detail.config

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import de.abacuselectronics.aroiorc.R

class ConfigFragment : Fragment(R.layout.fragment_detail_config) {

  private lateinit var wlanSwitch: SwitchMaterial
  private lateinit var autoConfigSwitch: SwitchMaterial

  private lateinit var hostnameEditText: TextInputEditText
  private lateinit var ipEditText: TextInputEditText
  private lateinit var subnetEditText: TextInputEditText
  private lateinit var gatewayEditText: TextInputEditText

  private lateinit var webinterfaceEditText: TextInputEditText

  private lateinit var radioAroioSu: RadioButton
  private lateinit var radioAroioOs: RadioButton
  private lateinit var radioAroioEx: RadioButton
  private lateinit var radioAroioLt: RadioButton

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Switches
    wlanSwitch = view.findViewById(R.id.switch_wlan)
    autoConfigSwitch = view.findViewById(R.id.switch_auto_config)

    // EditTexts
    hostnameEditText = view.findViewById(R.id.detail_config_hostname_edit_text)
    ipEditText = view.findViewById(R.id.detail_config_ip_edit_text)
    subnetEditText = view.findViewById(R.id.detail_config_subnet_edit_text)
    gatewayEditText = view.findViewById(R.id.detail_config_gateway_edit_text)

    webinterfaceEditText =
      view.findViewById(R.id.detail_config_webinterface_edit_text)

    // Radio Buttons
    radioAroioSu = view.findViewById(R.id.detail_config_platform_aroiosu)
    radioAroioOs = view.findViewById(R.id.detail_config_platform_aroioos)
    radioAroioEx = view.findViewById(R.id.detail_config_platform_aroioex)
    radioAroioLt = view.findViewById(R.id.detail_config_platform_aroiolt)
  }


  companion object {
    fun newInstance() = ConfigFragment()
  }
}