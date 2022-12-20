package com.example.studentbeansandroidjuniorapplication.utils

import android.view.View
import android.view.View.*
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.studentbeansandroidjuniorapplication.R
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus.*
import timber.log.Timber

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("studentBeansApiStatus")
fun bindStatus(imgView: ImageView, status: StudentBeansApiStatus) {
    imgView.apply {
        when(status) {
            LOADING -> {
                visibility = VISIBLE
                setImageResource(R.drawable.loading_animation)
            }
            ERROR -> {
                visibility = VISIBLE
                setImageResource(R.drawable.ic_connection_error)
            }
            DONE -> visibility = GONE
        }
    }
}