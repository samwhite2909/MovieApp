package com.swhite.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.swhite.movieapp.R
import com.swhite.movieapp.model.Movie
import com.swhite.movieapp.model.getMovies
import com.swhite.movieapp.nav.MovieScreens
import com.swhite.movieapp.widgets.MovieRow

//Main screen showing a list of movies.
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        //Setting up the app bar for this screen.
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 5.dp
            ) {
                Spacer(
                    modifier = Modifier.width(40.dp)
                )
                Text(
                    text = stringResource(R.string.movies)
                )
            }
        },
    ) {
        MainContent(navController = navController)
    }
}

//Displays content of the main screen.
@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        //Create a list of all movies, which are displayed in their own cards.
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    //If a movie is selected, show the details screen for that movie.
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
    Surface(color = MaterialTheme.colors.background) {}
}


