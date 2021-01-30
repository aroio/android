package de.abacuselectronics.aroiorc.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.abacuselectronics.aroiorc.R
import de.abacus.aroio.domain.models.Aroio

class AroioListAdapter(private val onClick: (Aroio) -> Unit) :
	RecyclerView.Adapter<AroioListAdapter.Holder>() {
	
	private var aroioListItems = listOf<Aroio>()
	
	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): Holder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.list_item_aroio, parent, false)
		return Holder(view)
	}
	
	override fun getItemCount(): Int = aroioListItems.size
	
	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(aroioListItems[position], onClick)
	}
	
	fun setAroioList(aroioList: List<Aroio>) {
		aroioListItems = aroioList
		notifyDataSetChanged()
	}
	
	class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private val name: AppCompatTextView =
			itemView.findViewById(R.id.aroio_list_name)
		private val ipAddress: AppCompatTextView =
			itemView.findViewById(R.id.aroio_list_ip_address)
		
		fun bind(aroio: Aroio, onClick: (Aroio) -> Unit) {
			name.text = aroio.name
			itemView.setOnClickListener { onClick(aroio) }
		}
	}
	
}
