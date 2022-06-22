package dev.eury.coroutinesbasics.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes res: Int): View = LayoutInflater.from(context).inflate(res, this, false)

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}

val RecyclerView.ViewHolder.context
    get() = itemView.context