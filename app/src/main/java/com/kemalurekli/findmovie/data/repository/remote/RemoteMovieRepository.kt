package com.kemalurekli.findmovie.data.repository.remote

import com.kemalurekli.findmovie.data.remote.dto.MovieAPI
import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto
import com.kemalurekli.findmovie.domain.repository.remote.RemoteMovieRepositoryInterface
import javax.inject.Inject

class RemoteMovieRepository
@Inject constructor
    (private val api: MovieAPI) :
    RemoteMovieRepositoryInterface {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }

}