package com.jwilder.flickr.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jwilder.flickr.dao.MovieDao
import com.jwilder.flickr.remote.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}