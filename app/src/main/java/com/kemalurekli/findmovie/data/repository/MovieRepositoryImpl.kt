package com.kemalurekli.findmovie.data.repository

import com.kemalurekli.findmovie.data.remote.dto.MovieAPI
import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto
import com.kemalurekli.findmovie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl
@Inject constructor
    (private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }

}