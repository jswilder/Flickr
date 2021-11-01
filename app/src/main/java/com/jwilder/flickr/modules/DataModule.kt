package com.jwilder.flickr.modules

import android.app.Application
import androidx.room.Room
import com.jwilder.flickr.db.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application) = Room.databaseBuilder(
        application.applicationContext,
        MovieDatabase::class.java,
        "movie_database"
    ).build()

    @Provides
    fun provides(movieDatabase: MovieDatabase) = movieDatabase.movieDao()
}