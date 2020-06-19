package com.boriskunda.boriskundainterview27520

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    private lateinit var nameTv: TextView
    private lateinit var capitalTv: TextView
    private lateinit var nativeNameTv: TextView
    private lateinit var regionTv: TextView
    private lateinit var flagIv: ImageView

    private val sharedViewModel: SharedViewModel by activityViewModels()//access ViewModel of activity,which fragment associates with

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi(view)

        sharedViewModel.selectedCountryLd.observe(viewLifecycleOwner, Observer {

            nameTv.text = it.name
            capitalTv.text = it.capital
            regionTv.text = it.region

            //glide implementation for SVG images
          //  GlideToVectorYou.justLoadImage(context as Activity, Uri.parse(it.flagUrl), flagIv)

        })

    }

    private fun initUi(view: View) {

        nameTv = view.findViewById(R.id.name_tv)
        capitalTv = view.findViewById(R.id.capital_tv)
        regionTv = view.findViewById(R.id.region_tv)
        flagIv = view.findViewById(R.id.flag_iv)

    }

}
