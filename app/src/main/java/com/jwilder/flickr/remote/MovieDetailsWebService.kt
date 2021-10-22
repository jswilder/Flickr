package com.jwilder.flickr.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailsWebService {

    /**
     * [searchTerm] e.g. "The Lion King"
     * [media] e.g. "movie"
     * [limit] e.g. "5", the number of results to return
     */
    @GET("/search")
    suspend fun fetchMovies(
        @Query("term") searchTerm: String,
        @Query("media") media: String,
        @Query("limit") limit: Int
    ): Response<ResponseWrapper>
}