package com.kemalurekli.findmovie.presentation.screens.watch_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kemalurekli.findmovie.domain.usecase.GetMovieUseCase
import com.kemalurekli.findmovie.presentation.screens.watch_list.views.WatchListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {

    private val _state = mutableStateOf<WatchListState>(WatchListState())
    val state: State<WatchListState> = _state

}