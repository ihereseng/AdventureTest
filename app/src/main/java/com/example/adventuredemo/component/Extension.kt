package com.example.adventuredemo.component

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageUrl(url: String?) {
    Glide.with(this.context).load(url).into(this)
}