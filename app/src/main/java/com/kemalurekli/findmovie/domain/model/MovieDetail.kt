package com.kemalurekli.findmovie.domain.model

import com.kemalurekli.findmovie.data.remote.dto.movies_detail.Rating

data class MovieDetail(
    val Actors: String,
    val Imdb_Id : String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Rated: String,
    val Released: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbRating: String,
)
