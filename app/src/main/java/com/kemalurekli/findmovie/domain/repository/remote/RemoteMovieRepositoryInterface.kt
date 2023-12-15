package com.kemalurekli.findmovie.domain.repository.remote

import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto

interface RemoteMovieRepositoryInterface {

    suspend fun getMovies (search : String) : MoviesDto
    suspend fun getMovieDetail (imdbId : String) : MovieDetailDto
}