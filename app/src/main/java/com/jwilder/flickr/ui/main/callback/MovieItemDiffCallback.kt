package com.jwilder.flickr.ui.main.callback

import androidx.recyclerview.widget.DiffUtil
import com.jwilder.flickr.remote.Movie

/**
 * Item callbvack to determine if two insatcnes of [Movie] are the same for the ListAdapter
 */
class MovieItemDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
}