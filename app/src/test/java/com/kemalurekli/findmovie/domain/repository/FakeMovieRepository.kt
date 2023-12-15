package com.kemalurekli.findmovie.domain.repository

import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies.Search
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.Rating
import com.kemalurekli.findmovie.domain.repository.remote.RemoteMovieRepositoryInterface

class FakeMovieRepository : RemoteMovieRepositoryInterface {
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