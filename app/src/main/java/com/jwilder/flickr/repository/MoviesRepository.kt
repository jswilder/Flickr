package com.jwilder.flickr.repository

import android.util.Log
import com.jwilder.flickr.remote.MovieDetailsWebService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MoviesRepository {

    private val client: OkHttpClient = OkHttpClient().newBuilder().build()
    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    private val service: MovieDetailsWebService =
        retrofit.create(MovieDetailsWebService::class.java)

    suspend fun fetchMovies() {
        try {
            val response = service.fetchMovies(
                "The Lion King",
                "movie",
                5
            )

            Log.d(TAG,"JEREMY** ${response.body()?.movieList.toString()}")

        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    companion object {
        private const val BASE_URL = "https://itunes.apple.com/"
        private val TAG = MoviesRepository::class.java.simpleName
    }
}