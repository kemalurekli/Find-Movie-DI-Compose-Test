package com.kemalurekli.findmovie.presentation.screens.watch_list_details.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kemalurekli.findmovie.domain.usecase.local.GetWatchListDetailFromDB
import com.kemalurekli.findmovie.presentation.screens.watch_list.views.WatchListState
import com.kemalurekli.findmovie.presentation.screens.watch_list_details.WatchListDetailState
import com.kemalurekli.findmovie.util.Constants
import com.kemalurekli.findmovie.util.Constants.IMDB_ID
import com.kemalurekli.findmovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WatchListDetailViewModel
    @Inject constructor(
        private val getWatchListDetailFromDB: GetWatchListDetailFromDB,
        private val stateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(WatchListDetailState())
    val state: State<WatchListDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            GetWatchlistDetail(it)
        }
    }
    private fun GetWatchlistDetail(imdbId: String) {
            getWatchListDetailFromDB.invoke(imdbId).onEach {
                when (it) {
                    is Resource.Success -> {
                        _state.value = WatchListDetailState(movie = it.data!!)
                    }

                    is Resource.Loading -> {
                        _state.value = WatchListDetailState(isLoading = true)
                    }

                    is Resource.Error -> {
                        _state.value = WatchListDetailState(error = it.message ?: "Error!")
                    }
                }
            }.launchIn(viewModelScope)
        }


}