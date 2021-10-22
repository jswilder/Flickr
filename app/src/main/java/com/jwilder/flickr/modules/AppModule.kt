package com.jwilder.flickr.modules

import com.jwilder.flickr.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(
        // TODO: Movies DAO
    ) = MoviesRepository(
        // TODO: Movies DAO
    )
}