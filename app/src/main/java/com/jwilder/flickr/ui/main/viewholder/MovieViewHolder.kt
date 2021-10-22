package com.jwilder.flickr.ui.main.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jwilder.flickr.R
import com.jwilder.flickr.remote.Movie

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val movieImage: ImageView = view.findViewById(R.id.movieImage)
    private val movieName: TextView = view.findViewById(R.id.nameText)
    private val movieDate: TextView = view.findViewById(R.id.releaseDateText)
    private val movieDesc: TextView = view.findViewById(R.id.descriptionText)

    fun bindTo(movie: Movie, context: Context) {
        movie.artworkUrl100?.let { url ->
            Glide.with(context).load(url).placeholder(R.drawable.ic_movie_black_24dp)
                .into(movieImage)
        }
        movieName.applyTextIfNotNull(movie.trackName)
        movieDate.applyTextIfNotNull(movie.releaseDate)
        movieDesc.applyTextIfNotNull(movie.shortDescription)
    }

    /**
     * Hides the text view if the [displayText] value is null or empty
     * Else is sets the text to the String provided
     */
    private fun TextView.applyTextIfNotNull(displayText: String?) {
        this.apply {
            visibility = if (displayText.isNullOrBlank()) View.GONE else View.VISIBLE
            text = displayText ?: ""
        }
    }
}