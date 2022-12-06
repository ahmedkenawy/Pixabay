package com.a7medkenawy.mypaging.presentaion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a7medkenawy.mypaging.databinding.ImageRowBinding
import com.a7medkenawy.mypaging.domain.model.Hit
import javax.inject.Inject


class ImagesAdapter @Inject constructor() :
    PagingDataAdapter<Hit, ImagesAdapter.ImageViewHolder>(DataDiffUtil) {


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var currentImage = getItem(position)
        holder.binding.hit = currentImage
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(ImageRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    class ImageViewHolder(val binding: ImageRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    object DataDiffUtil : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

    }
}