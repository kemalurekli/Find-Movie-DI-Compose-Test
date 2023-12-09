package com.kemalurekli.findmovie.presentation.movies.views

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kemalurekli.findmovie.domain.model.Movie
import com.kemalurekli.findmovie.domain.repository.FakeMovieRepository
import com.kemalurekli.findmovie.domain.usecase.GetMovieUseCase
import com.kemalurekli.findmovie.presentation.screens.movies.MoviesViewModel
import com.kemalurekli.findmovie.util.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieViewModelTest {
    @get : Rule
    var instantTaskExecutorRule  = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get: Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMovieUseCase(fakeMovieRepository)
        viewModel = MoviesViewModel(getMovieUseCase)
    }

    @Test
    fun `get Movie for Searched keyword`() {
        //val value = viewModel.state.value.search
        //assertThat(value).contains("Welcome")
       viewModel.getMovies("Batman")
        assertThat(viewModel.state.value.movies).isNotEmpty()

    }


}