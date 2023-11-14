package com.kemalurekli.findmovie.domain.usecase

import android.net.http.HttpException
import com.kemalurekli.findmovie.data.remote.mapper.toMovieList
import com.kemalurekli.findmovie.domain.model.Movie
import com.kemalurekli.findmovie.domain.repository.MovieRepository
import com.kemalurekli.findmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error(message = "Not Found!"))
            }

        }catch (e : IOError) {
            emit(Resource.Error(message = "No Internet Connection"))
        }catch (e : retrofit2.HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}