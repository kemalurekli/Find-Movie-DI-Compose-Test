package com.kemalurekli.findmovie.data.remote.mapper

import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto
import com.kemalurekli.findmovie.domain.model.MovieDetail

fun MovieDetailDto.toMovieDetail () : MovieDetail {
    return MovieDetail(Actors, Awards, Country, Director, Genre, Language, Poster, Rated, Released, Title, Type, Year, imdbRating)
}