package com.jwilder.flickr.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwilder.flickr.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    fun fetMovieData() {
        viewModelScope.launch {
            moviesRepository.fetchMovies()
        }
    }
}