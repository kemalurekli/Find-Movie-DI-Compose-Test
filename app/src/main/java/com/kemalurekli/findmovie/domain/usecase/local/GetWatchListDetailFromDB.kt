package com.kemalurekli.findmovie.domain.usecase.local

import com.kemalurekli.findmovie.data.local.roomdb.WatchList
import com.kemalurekli.findmovie.domain.repository.local.LocalMovieRepositoryInterFace
import com.kemalurekli.findmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetWatchListDetailFromDB @Inject constructor(
    private val repository: LocalMovieRepositoryInterFace
) {
    fun invoke(imdb_ID : String): Flow<Resource<WatchList>> = flow {
        try {
            emit(Resource.Loading())
            val watchList = repository.getWatchDetail(imdb_ID)
            if (watchList.movieName.isNotEmpty()) {
                emit(Resource.Success(watchList))
            } else {
                emit(Resource.Error(message = "Not Found!"))
            }
        } catch (e: IOError) {
            emit(Resource.Error(message = "Something Wrong"))
        }
    }
}