package com.swhite.movieapp.nav

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    //Handles routes for navigation to the different screens.
    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognised")
        }
    }
}