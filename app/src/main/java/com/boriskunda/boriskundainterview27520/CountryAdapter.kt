package com.boriskunda.boriskundainterview27520

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.boriskunda.boriskundainterview27520.databinding.ItemCountryLlBinding
import com.boriskunda.boriskundainterview27520.model.Country
import java.util.*

class CountryAdapter(
    private val onRVItemClickListener: OnRVItemClickListener
) :
    RecyclerView.Adapter<CountryAdapter.VH>() {

    var countriesList: List<Country> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val bindingVH: ItemCountryLlBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_country_ll, parent, false)
        return VH(bindingVH)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val country = countriesList[position]
        holder.binding.country = country
        holder.binding.rvItemClickListener = onRVItemClickListener

    }

    class VH(bindingItem: ItemCountryLlBinding) : RecyclerView.ViewHolder(bindingItem.root) {
        var binding: ItemCountryLlBinding = bindingItem
    }

    interface OnRVItemClickListener {
        fun onRVItemClick(country: Country)
    }

}
