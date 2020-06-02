package com.boriskunda.boriskundainterview27520

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import java.util.*

class CountryAdapter(
    private val activity: Activity,
    private val onRVItemClickListener: OnRVItemClickListener
) :
    RecyclerView.Adapter<CountryAdapter.VH>() {

    var countriesList: List<Country> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_country_ll, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val country = countriesList[position]
        holder.itemTv.text = country.name
        //glide implementation for SVG images
        GlideToVectorYou.justLoadImage(activity, Uri.parse(country.flagUrl), holder.itemIv)

        holder.itemView.setOnClickListener {
            onRVItemClickListener.onRVItemClick(countriesList[position])
        }

    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTv: TextView = itemView.findViewById(R.id.item_tv)
        val itemIv: ImageView = itemView.findViewById(R.id.item_iv)

    }

    interface OnRVItemClickListener {
        fun onRVItemClick(country: Country)
    }

}
