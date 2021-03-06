package com.jwilder.flickr.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Models for the Web Response
 */
@JsonClass(generateAdapter = true)
data class ResponseWrapper(
    @Json(name = "results")
    val movieList: List<Movie>
)

@Entity(tableName = "movie_database")
@JsonClass(generateAdapter = true)
data class Movie(
    @PrimaryKey
    val trackName: String,
    val releaseDate: String?,
    val artworkUrl100: String?,
    val shortDescription: String?
)