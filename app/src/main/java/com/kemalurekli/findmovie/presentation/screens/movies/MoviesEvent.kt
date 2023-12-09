package com.kemalurekli.findmovie.presentation.screens.movies

sealed class MoviesEvent {
    data class Search (val searchString : String) : MoviesEvent()
}