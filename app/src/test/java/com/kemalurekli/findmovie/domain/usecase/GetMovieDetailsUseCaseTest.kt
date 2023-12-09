package com.kemalurekli.findmovie.domain.usecase


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.MovieDetailDto
import com.kemalurekli.findmovie.data.remote.dto.movies_detail.Rating
import com.kemalurekli.findmovie.domain.repository.FakeMovieRepository
import com.kemalurekli.findmovie.util.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetMovieDetailsUseCaseTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var getMoviesDetailsUseCase: GetMovieDetailsUseCase
    private lateinit var fakeMovieListRepository: FakeMovieRepository

    @Before
    fun setUp() {
        fakeMovieListRepository = FakeMovieRepository()
        getMoviesDetailsUseCase = GetMovieDetailsUseCase(fakeMovieListRepository)
        fakeMovieListRepository.fakeSource2 = MovieDetailDto("", "", "", "", "", "", "", "", "", "", "", "", "", listOf(
            Rating("", "")
        ), "", "", "", "Movie Title", "", "", "", "", "", "", "")

    }

    @Test
    fun `Get the movie for IMDB ID and Check Movie Title`() = runBlocking {
        var mockMovie : String? = ""
        getMoviesDetailsUseCase.executeGetMoviesDetails("abc").collectLatest {
            mockMovie = it.data?.Title
        }
        assertThat(mockMovie).isEqualTo("Movie Title")

    }
}