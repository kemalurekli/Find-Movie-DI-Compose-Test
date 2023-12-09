package com.kemalurekli.findmovie.domain.repository

import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies.Search
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.Rating
import javax.inject.Inject

class FakeMovieRepository : MovieRepositoryInterface {
    var fakeSource1 =
        MoviesDto("", listOf(Search("", "", "", "", "")), "")

    var fakeSource2 = MovieDetailDto("", "", "", "", "", "", "", "", "", "", "", "", "", listOf(Rating("", "")), "", "", "", "", "", "", "", "", "", "", "")


    override suspend fun getMovies(search: String): MoviesDto {
        return fakeSource1
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return fakeSource2
    }


}