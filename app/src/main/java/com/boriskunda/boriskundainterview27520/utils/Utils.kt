package com.boriskunda.boriskundainterview27520.utils


import android.app.Activity
import android.content.res.Resources
import android.net.Uri
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.boriskunda.boriskundainterview27520.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


const val GET_ALL_COUNTRIES_URL = "https://restcountries.eu/rest/v2/all"
const val SPLASH_DURATION: Long = 3000

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: String?) {

    GlideToVectorYou.justLoadImage(view.context as Activity, Uri.parse(imageUrl), view)

}

fun setStatusBarColor(
    iWindow: Window,
    iResources: Resources
) {
    iWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    iWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    iWindow.statusBarColor = iResources.getColor(R.color.colorGrey)
}
