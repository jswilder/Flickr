package com.jwilder.flickr.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseWrapper(
    @Json(name = "results")
    val movieList: List<MovieData>
)

@JsonClass(generateAdapter = true)
data class MovieData(
    val trackName: String?,
    val releaseDate: String?,
    val artworkUrl100: String?,
    val shortDescription: String?
)