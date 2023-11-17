package com.kemalurekli.findmovie.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kemalurekli.findmovie.domain.usecase.GetMovieUseCase
import com.kemalurekli.findmovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) :
    ViewModel() {

    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state: State<MoviesState> = _state

    //We created the job if you have another jobs and you can handle it.
    private val job: Job? = null

    //This is for "welcome" search
    init {
        getMovies(_state.value.search)
    }

    private fun getMovies(search: String) {
        job?.cancel()
        getMovieUseCase.executeGetMovies(search).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MoviesState(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = MoviesState(error = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event : MoviesEvent) {
        when(event) {
            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }
        }

    }

}