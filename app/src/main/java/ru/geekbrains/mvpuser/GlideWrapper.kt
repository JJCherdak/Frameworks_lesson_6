package ru.geekbrains.mvpuser

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class GlideWrapper
    @Inject constructor(
        private val context: Context
    ) {

        fun loadImage(imageUrl: String, imageView: ImageView){
            Glide.with(context)
                .load(imageUrl)
                .into(imageView)
        }
    }
