package com.kemalurekli.findmovie.data.remote.dto.movies

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)