package com.kemalurekli.findmovie.presentation.movie_details

import com.kemalurekli.findmovie.domain.model.MovieDetail

data class MovieDetailState(
  val isLoading : Boolean = false,
  val movie: MovieDetail? = null,
  val error : String = ""
)