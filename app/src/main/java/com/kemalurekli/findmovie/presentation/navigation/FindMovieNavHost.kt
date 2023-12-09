package com.kemalurekli.findmovie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kemalurekli.findmovie.presentation.screens.movie_details.views.MovieDetailScreen
import com.kemalurekli.findmovie.presentation.screens.movies.views.MovieScreen
import com.kemalurekli.findmovie.presentation.screens.watch_list.views.WatchListScreen
import com.kemalurekli.findmovie.util.Constants

@Composable
fun FindMovieNavHost(
    modifier: Modifier = Modifier,
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MovieScreen.route
    ) {
        composable(route = Screen.MovieScreen.route) {
            MovieScreen(navController = navController)
        }
        composable(route = Screen.MovieDetailScreen.route + "/{${Constants.IMDB_ID}}") {
            MovieDetailScreen()
        }
        composable(route = Screen.WatchListScreen.route) {
            WatchListScreen(navController = navController)
        }
    }
}