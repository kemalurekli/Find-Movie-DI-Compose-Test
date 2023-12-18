package com.kemalurekli.findmovie.presentation.screens.watch_list_details

import com.kemalurekli.findmovie.data.local.roomdb.WatchList

data class WatchListDetailState (
    val isLoading : Boolean = false,
    val movie: WatchList? = null,
    val error : String = ""
)