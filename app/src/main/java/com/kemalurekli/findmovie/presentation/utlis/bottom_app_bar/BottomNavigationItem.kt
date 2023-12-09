package com.kemalurekli.findmovie.presentation.utlis.bottom_app_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.kemalurekli.findmovie.presentation.navigation.Screen


sealed class BottomNavigationItem(val route: String, val title : String, val icon: ImageVector){
    object Movies : BottomNavigationItem(Screen.MovieScreen.route,"Movies",Icons.Rounded.Home)
    object WatchList : BottomNavigationItem(Screen.WatchListScreen.route,"Watch List",Icons.Rounded.List)

}