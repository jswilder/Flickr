package com.jwilder.flickr.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.jwilder.flickr.remote.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Query("SELECT * FROM movie_database")
    suspend fun getAll(): List<Movie>
}