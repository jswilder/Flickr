package com.jwilder.flickr.ui.main.callback

import androidx.recyclerview.widget.DiffUtil
import com.jwilder.flickr.remote.Movie

class MovieItemDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
}