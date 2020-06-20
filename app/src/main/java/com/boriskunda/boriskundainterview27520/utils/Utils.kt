package com.boriskunda.boriskundainterview27520.utils


import android.app.Activity
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener


const val GET_ALL_COUNTRIES_URL = "https://restcountries.eu/rest/v2/all"
//const val SPLASH_DURATION: Long = 3000
const val SPLASH_DURATION: Long = 0

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: String?) {

    GlideToVectorYou.justLoadImage(view.context as Activity, Uri.parse(imageUrl), view)

    // Easy // GlideToVectorYou.justLoadImage(view.context as Activity, Uri.parse(imageUrl), view)
    /**--*/
    /*Normal
  GlideToVectorYou
        .init()
        .with(view.context)
        .withListener(object : GlideToVectorYouListener {
            override fun onLoadFailed() {

            }

            override fun onResourceReady() {

            }
        })
       // .setPlaceHolder(placeholderLoading, placeholderError)
        .load(Uri.parse(imageUrl), view)
     */
    /**--*/
    /*Pro

   val requestBuilder: RequestBuilder<PictureDrawable> = GlideToVectorYou
        .init()
        .with(view.context)
        .requestBuilder
    requestBuilder
        .load(Uri.parse(imageUrl))
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(RequestOptions().centerCrop()
        )
        .into(view)
     */

}

