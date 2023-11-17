package com.kemalurekli.findmovie.presentation.movies

import com.kemalurekli.findmovie.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "Welcome"

)
