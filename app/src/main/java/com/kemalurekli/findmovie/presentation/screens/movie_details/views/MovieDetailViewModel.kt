package com.kemalurekli.findmovie.presentation.screens.movie_details.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kemalurekli.findmovie.data.local.roomdb.WatchList
import com.kemalurekli.findmovie.domain.usecase.remote.GetMovieDetailsUseCase
import com.kemalurekli.findmovie.domain.usecase.local.SaveWatchListUseCase
import com.kemalurekli.findmovie.presentation.screens.movie_details.MovieDetailState
import com.kemalurekli.findmovie.util.Constants.IMDB_ID
import com.kemalurekli.findmovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val saveWatchListUseCase: SaveWatchListUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }


    private fun getMovieDetail(imdbId : String) {
        getMovieDetailsUseCase.executeGetMoviesDetails(imdbId).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun saveRoom() =  viewModelScope.launch {
        state.value.movie.let {
            val watchList = WatchList(it!!.Title,it.imdbRating,it.Year,it.Poster)
            saveWatchListUseCase.invoke(watchList)
        }
    }
}