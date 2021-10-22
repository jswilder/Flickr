package com.jwilder.flickr.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseWrapper(
    @Json(name = "results")
    val movieList: List<Movie>
)

@JsonClass(generateAdapter = true)
data class Movie(
    val trackName: String?,
    val releaseDate: String?,
    val artworkUrl100: String?,
    val shortDescription: String?
)