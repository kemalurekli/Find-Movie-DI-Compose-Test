package com.kemalurekli.findmovie.domain.usecase

import com.kemalurekli.findmovie.data.remote.mapper.toMovieDetail
import com.kemalurekli.findmovie.domain.model.MovieDetail
import com.kemalurekli.findmovie.domain.repository.MovieRepositoryInterface
import com.kemalurekli.findmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepositoryInterface
) {
    fun executeGetMoviesDetails(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))

        } catch (e: IOError) {
            emit(Resource.Error(message = "No Internet Connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}