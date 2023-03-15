package com.swhite.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.swhite.movieapp.nav.MovieNavigation
import com.swhite.movieapp.ui.theme.MovieAppTheme

//Main activity.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application {
                MovieNavigation()
            }
        }
    }
}

//Sets screen content when given a navigation result.
@Composable
fun Application(content: @Composable () -> Unit) {
    MovieAppTheme {
        content()
    }
}

//Used for previewing full app.
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Application {
        MovieNavigation()
    }
}