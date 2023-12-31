package com.kemalurekli.findmovie.presentation.screens.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kemalurekli.findmovie.presentation.navigation.Screen
import com.kemalurekli.findmovie.presentation.screens.movies.MoviesEvent
import com.kemalurekli.findmovie.presentation.screens.movies.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                hint = "superman", onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                })
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) { movie ->
                    MovieListRow(
                        movie = movie,
                        onItemClick = {
                            navController.navigate(Screen.MovieDetailScreen.route + "/${movie.imdbID}")
                            //navController.navigate(Screen.WatchListScreen.route)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieScreenPreview() {
    MovieScreen(navController = rememberNavController())
}
