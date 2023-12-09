package com.kemalurekli.findmovie.presentation.utlis.bottom_app_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CustomBottomAppBar(
    navController: NavController
) {
    val list = listOf(
        BottomNavigationItem.Movies,
        BottomNavigationItem.WatchList
    )
    NavigationBar {
        list.forEach { bottomItem ->
            NavigationBarItem(
                selected = navController.currentDestination?.route == bottomItem.route,
                onClick = {
                    navController.navigate(bottomItem.route) {
                        //This is for backstack control
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = bottomItem.icon,
                        contentDescription = bottomItem.title
                    )
                },
                label = { Text(text = bottomItem.title) })
        }
    }

}