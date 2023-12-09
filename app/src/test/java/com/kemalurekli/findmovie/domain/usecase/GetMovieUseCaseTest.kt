package com.kemalurekli.findmovie.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kemalurekli.findmovie.data.remote.dto.movies.MoviesDto
import com.kemalurekli.findmovie.data.remote.dto.movies.Search
import com.kemalurekli.findmovie.domain.repository.FakeMovieRepository
import com.kemalurekli.findmovie.util.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetMovieUseCaseTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var getMoviesUseCase: GetMovieUseCase
    private lateinit var fakeMovieListRepository: FakeMovieRepository


    @Before
    fun setUp() {
        fakeMovieListRepository = FakeMovieRepository()
        getMoviesUseCase = GetMovieUseCase(fakeMovieListRepository)
    }

    @Test
    fun `If response 'True', search to Movie List return Success`() = runBlocking {
        var mockMovie: String? = ""
        fakeMovieListRepository.fakeSource1 = MoviesDto("True", listOf(Search("Poster URL", "MockDataTitle", "Action", "1992", "w121w")), "23")
        getMoviesUseCase.invoke("abc").collectLatest { resource ->
            resource.data?.forEach {
                mockMovie = it.Title
            }
        }
        assertThat(mockMovie).isEqualTo("MockDataTitle")
    }

    @Test
    fun `If response 'False', Search to Movie List Title return Empty`() = runBlocking {
        var mockMovie: String? = ""
        fakeMovieListRepository.fakeSource1 = MoviesDto("False", listOf(Search("Poster URL", "MockDataTitle", "Action", "1992", "w121w")), "23")
        getMoviesUseCase.invoke("abc").collectLatest { resource ->
            resource.data?.forEach {
                mockMovie = it.Title
            }
        }
        assertThat(mockMovie).isEmpty()
    }
}


