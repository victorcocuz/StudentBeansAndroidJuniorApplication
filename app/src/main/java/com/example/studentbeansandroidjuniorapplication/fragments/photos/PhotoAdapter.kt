package com.example.studentbeansandroidjuniorapplication.fragments.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studentbeansandroidjuniorapplication.databinding.ItemPhotoViewBinding
import com.example.studentbeansandroidjuniorapplication.domain.DomainPhoto
import com.example.studentbeansandroidjuniorapplication.utils.bindImage

class PhotoAdapter : ListAdapter<DomainPhoto, PhotoAdapter.ViewHolder>(DiffCallBack) {
    val data = listOf<DomainPhoto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemPhotoViewBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemPhotoViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: DomainPhoto) {
            binding.apply {
                iPhotoViewIvImage.bindImage(item.thumbnailUrl)
                iPhotoViewTvText.text = item.title
            }
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<DomainPhoto>() {
        override fun areItemsTheSame(oldItem: DomainPhoto, newItem: DomainPhoto): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DomainPhoto, newItem: DomainPhoto): Boolean {
            return oldItem.albumId == newItem.albumId
        }
    }
}


