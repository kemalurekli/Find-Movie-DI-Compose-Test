package com.kemalurekli.findmovie.presentation.screens.watch_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kemalurekli.findmovie.data.local.roomdb.WatchList
import com.kemalurekli.findmovie.domain.usecase.local.DeleteFromWatchListUseCase
import com.kemalurekli.findmovie.domain.usecase.local.GetWatchListUseCase
import com.kemalurekli.findmovie.presentation.screens.watch_list.views.WatchListState
import com.kemalurekli.findmovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val getWatchListUseCase: GetWatchListUseCase,
    private val deleteFromWatchListUseCase: DeleteFromWatchListUseCase
) :
    ViewModel() {

    private val _state = mutableStateOf<WatchListState>(WatchListState())
    val state: State<WatchListState> = _state


    init {
        getWatchList()
    }

    private fun getWatchList() {
        getWatchListUseCase.invoke().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = WatchListState(movies = it.data!!)
                }

                is Resource.Loading -> {
                    _state.value = WatchListState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = WatchListState(error = it.message ?: "Error!")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun deleteFromWatchList(watchList: WatchList) {
        viewModelScope.launch(){
            deleteFromWatchListUseCase.invoke(watchList)
            getWatchList()
        }
    }

}