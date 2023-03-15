package com.swhite.movieapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swhite.movieapp.screens.details.DetailsScreen
import com.swhite.movieapp.screens.home.HomeScreen

//Handles navigation within the app using the nav controller and the names of the screens.
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    //Create a nav host with a nav controller.
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        //Home screen.
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        //Details screen.
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) {
            //Hitting the back button takes them back to the movies screen.
            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}