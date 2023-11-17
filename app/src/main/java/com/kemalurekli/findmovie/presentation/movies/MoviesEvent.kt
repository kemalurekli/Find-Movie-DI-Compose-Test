package com.kemalurekli.findmovie.presentation.movies

sealed class MoviesEvent {
    data class Search (val searchString : String) : MoviesEvent()
}