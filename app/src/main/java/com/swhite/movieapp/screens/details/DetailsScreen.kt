package com.swhite.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.swhite.movieapp.R
import com.swhite.movieapp.model.getMovies
import com.swhite.movieapp.widgets.HorizontalScrollableImageView
import com.swhite.movieapp.widgets.MovieRow

//Additional details for a movie screen.
@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
) {
    //Gets the movie from the list of movies to display.
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    //Setting up the app bar.
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
            elevation = 5.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.arrow_back),
                    modifier = Modifier.clickable {
                        //Go back to the last screen shown using the nav controller.
                        navController.popBackStack()
                    })
                Spacer(
                    modifier = Modifier.width(20.dp)
                )
            }
            Text(
                text = stringResource(R.string.movies)
            )
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                //Display the movie card again, along with additional images.
                MovieRow(movie = newMovieList.first())
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                HorizontalScrollableImageView(newMovieList)
            }
        }
    }
}

