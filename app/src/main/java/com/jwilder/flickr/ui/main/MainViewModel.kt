package com.jwilder.flickr.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwilder.flickr.remote.Movie
import com.jwilder.flickr.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    /**
     * Backing field for the list of movies
     */
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    /**
     * Fetch a [List] of [Movie] from [MoviesRepository] and post the response using the background
     * thread
     */
    fun fetMovieData() {
        viewModelScope.launch {
            _movieList.postValue(moviesRepository.fetchMovies())
        }
    }
}