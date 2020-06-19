package com.boriskunda.boriskundainterview27520


import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


const val GET_ALL_COUNTRIES_URL = "https://restcountries.eu/rest/v2/all"
const val SPLASH_DURATION: Long = 3000

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: String?) {

    GlideToVectorYou.justLoadImage(view.context as Activity, Uri.parse(imageUrl), view)

}
