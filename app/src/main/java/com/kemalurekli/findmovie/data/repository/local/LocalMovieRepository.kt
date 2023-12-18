package com.kemalurekli.findmovie.data.repository.local

import com.kemalurekli.findmovie.data.local.roomdb.WatchList
import com.kemalurekli.findmovie.data.local.roomdb.WatchListDao
import com.kemalurekli.findmovie.domain.repository.local.LocalMovieRepositoryInterFace
import javax.inject.Inject

class LocalMovieRepository @Inject constructor(
    private val dao: WatchListDao
) : LocalMovieRepositoryInterFace {
    override suspend fun insertWatchList(watchList: WatchList) {
        dao.insertWatchList(watchList)
    }

    override suspend fun deleteWatchList(watchList: WatchList) {
        dao.deleteWatchList(watchList)
    }

    override suspend fun getWatchList(): List<WatchList> {
        return dao.getWatchList()
    }

    override suspend fun getWatchDetail(imdbId: String): WatchList {
        return dao.getWatchListDetail(imdbId)
    }

}