package com.jwilder.flickr.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jwilder.flickr.R
import com.jwilder.flickr.remote.Movie
import com.jwilder.flickr.ui.main.callback.MovieItemDiffCallback
import com.jwilder.flickr.ui.main.viewholder.MovieViewHolder

class MovieListAdapter(val context: Context) :
    ListAdapter<Movie, MovieViewHolder>(MovieItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_movie_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindTo(getItem(position), context)
    }
}