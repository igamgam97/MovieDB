package com.noveogroup.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noveogroup.moviecatalog.feature.movielist.presentation.MovieListRoute
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieCatalogNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route
    ) {
        composable(route = Screen.MovieList.route) {
            MovieListRoute(
                viewModel = koinViewModel(),
                navigateToMovieDetails = { }
            )
        }
    }
}
