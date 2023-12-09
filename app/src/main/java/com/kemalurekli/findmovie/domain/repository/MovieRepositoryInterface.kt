package com.kemalurekli.findmovie.domain.repository

import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto

interface MovieRepositoryInterface {

    suspend fun getMovies (search : String) : MoviesDto
    suspend fun getMovieDetail (imdbId : String) : MovieDetailDto
}