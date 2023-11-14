package com.kemalurekli.findmovie.data.remote.mapper

import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.domain.model.Movie

fun MoviesDto.toMovieList():List<Movie>{
    return Search.map {
        search -> Movie(search.Poster, search.Title,search.Year,search.imdbID )
    }
}