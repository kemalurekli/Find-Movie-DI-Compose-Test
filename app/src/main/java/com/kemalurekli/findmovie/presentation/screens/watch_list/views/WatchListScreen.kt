package com.kemalurekli.findmovie.presentation.screens.watch_list.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kemalurekli.findmovie.presentation.screens.watch_list.WatchListViewModel

@Composable
fun WatchListScreen(
    navController: NavController,
    viewModel: WatchListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.padding(top = 10.dp)) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) { watchList ->
                    WatchListRow(
                        watchList = watchList,
                        onItemClick = {
                           // navController.navigate(Screen.MovieDetailScreen.route + "/${watchList.id}")
                        }
                    )
                }
            }
        }
    }

}