package com.example.contriesflagapi

import PhotoGridAdapter
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.contriesflagapi.network.contriemodel
import com.example.contriesflagapi.network.dataarray
import java.util.*

@BindingAdapter("photoUrl")
fun ImageView.bind(photoUrl: String?){
    photoUrl?.let {
    val photoUri = photoUrl.toUri().buildUpon().scheme("https").build()
    this.load(photoUri) {
        placeholder(R.drawable.loading_animation)
        error(R.drawable.ic_broken_image)
       }
    }
}


@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(data: List<contriemodel>
) {
    if (this.adapter == null) {
        this.adapter = PhotoGridAdapter()
    }

    val adapter = this.adapter as PhotoGridAdapter
    adapter.submitList(data)
}