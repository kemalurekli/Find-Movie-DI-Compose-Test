package com.kemalurekli.findmovie.presentation.screens.watch_list.views

import com.kemalurekli.findmovie.data.local.roomdb.WatchList

data class WatchListState(
    val isLoading : Boolean = false,
    val movies : List<WatchList> = emptyList(),
    val error : String = "",
    val search : String = "Welcome"
)
