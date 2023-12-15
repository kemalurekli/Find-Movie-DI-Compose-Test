package com.kemalurekli.findmovie.domain.usecase.local

import com.kemalurekli.findmovie.data.local.roomdb.WatchList
import com.kemalurekli.findmovie.domain.repository.local.LocalMovieRepositoryInterFace
import com.kemalurekli.findmovie.util.Resource
import java.io.IOError
import javax.inject.Inject

class DeleteFromWatchListUseCase @Inject constructor(
    private val repository: LocalMovieRepositoryInterFace
) {
    suspend fun invoke (watchList: WatchList)  {
        try {
            repository.deleteWatchList(watchList)
        } catch (e: IOError) {
            Resource.Error(message = "Something Wrong",null)
        }
    }
}