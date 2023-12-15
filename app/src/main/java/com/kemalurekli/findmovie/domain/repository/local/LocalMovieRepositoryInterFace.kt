package com.kemalurekli.findmovie.domain.repository.local

import com.kemalurekli.findmovie.data.local.roomdb.WatchList

interface LocalMovieRepositoryInterFace {
    suspend fun insertWatchList(watchList: WatchList)
    suspend fun deleteWatchList(watchList: WatchList)
    suspend fun getWatchList () : List<WatchList>
}