package de.abacuselectronics.aroiorc.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacuselectronics.aroiorc.datasource.local.Aroio

class AroioListAdapter : RecyclerView.Adapter<AroioListAdapter.Holder>() {
	
	private var aroioListItems = listOf<Aroio>()
	
	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): AroioListAdapter.Holder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.recycleritem_aroio_list, parent, false)
		return Holder(view)
	}
	
	override fun getItemCount(): Int = aroioListItems.size
	
	override fun onBindViewHolder(
		holder: AroioListAdapter.Holder,
		position: Int
	) {
		holder.bind(aroioListItems[position])
	}
	
	fun setAroios(aroios: List<Aroio>) {
		aroioListItems = aroios
		notifyDataSetChanged()
	}
	
	class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private val name: AppCompatTextView =
			itemView.findViewById(R.id.aroio_list_name)
		private val ipAddress: AppCompatTextView =
			itemView.findViewById(R.id.aroio_list_ip_address)
		
		fun bind(aroio: Aroio) {
			name.text = aroio.name
			ipAddress.text = aroio.ipAddress
		}
	}
	
}
