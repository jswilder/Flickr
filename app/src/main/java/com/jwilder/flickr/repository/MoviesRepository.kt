package com.jwilder.flickr.repository

import android.util.Log
import com.jwilder.flickr.dao.MovieDao
import com.jwilder.flickr.remote.Movie
import com.jwilder.flickr.remote.MovieDetailsWebService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Repository class to fetch the [List] of [Movie] from the web and eventually the persisted data
 */
class MoviesRepository(
    val movieDao: MovieDao
) {

    private val client: OkHttpClient = OkHttpClient().newBuilder().build()
    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service: MovieDetailsWebService =
        retrofit.create(MovieDetailsWebService::class.java)

    suspend fun fetchMovies(): List<Movie> {
        return try {
            val response = service.fetchMovies(
                "The Lion King",
                "movie",
                5
            )

            return if (response.isSuccessful) {
                response.body()?.movieList?.let {
                    movieDao.insertAll(it)
                }
                response.body()?.movieList ?: movieDao.getAll()
            } else movieDao.getAll()

        } catch (e: Exception) {
            Log.e(TAG, e.toString())
            movieDao.getAll()
        }
    }

    companion object {
        private const val BASE_URL = "https://itunes.apple.com/"
        private val TAG = MoviesRepository::class.java.simpleName
    }
}