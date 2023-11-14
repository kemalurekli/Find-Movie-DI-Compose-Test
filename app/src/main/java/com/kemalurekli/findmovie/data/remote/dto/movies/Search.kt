package com.kemalurekli.findmovie.data.remote.dto.movies

data class Search(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
)