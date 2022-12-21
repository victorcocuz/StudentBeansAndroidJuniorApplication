package com.example.studentbeansandroidjuniorapplication.utils

import android.view.View.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studentbeansandroidjuniorapplication.R
import com.example.studentbeansandroidjuniorapplication.domain.DomainPhoto
import com.example.studentbeansandroidjuniorapplication.fragments.photos.PhotoAdapter
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus
import com.example.studentbeansandroidjuniorapplication.network.StudentBeansApiStatus.*
import timber.log.Timber

@BindingAdapter("studentBeansApiStatus", "imageListSize")
fun bindStatus(imgView: ImageView, status: StudentBeansApiStatus?, photos: List<DomainPhoto>?) {
        imgView.apply {
            visibility = GONE
            if (photos == null || photos.isEmpty()) { // Only add loading/error image when db is empty
                when (status) {
                LOADING -> {
                    visibility = VISIBLE
                    setImageResource(R.drawable.loading_animation)
                }
                ERROR -> {
                    visibility = VISIBLE
                    setImageResource(R.drawable.ic_connection_error)
                }
                else -> visibility = GONE
            }
        }
    }
}

@BindingAdapter("bindPhotosData")
fun RecyclerView.bindPhotosData(photos: MutableList<DomainPhoto>?) = photos?.let {
    Timber.e("list is submitted")
    val adapter = this.adapter as PhotoAdapter
    adapter.submitList(photos)
}