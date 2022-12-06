package com.a7medkenawy.mypaging.presentaion.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.a7medkenawy.mypaging.R

class ImageBindingAdapter {

    companion object {

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, ulr: String) {
            imageView.load(ulr) {
                crossfade(600)
                error(R.drawable.ic_image)
            }
        }
    }
}