package com.noveogroup.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.noveogroup.moviecatalog.feature.moviedetail.presentation.movieDetails
import com.noveogroup.moviecatalog.feature.moviedetail.presentation.navigateToDetails
import com.noveogroup.moviecatalog.feature.movielist.presentation.movieList
import com.noveogroup.moviecatalog.feature.movielist.presentation.movieListRoute

@Composable
fun MovieCatalogNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = movieListRoute
    ) {
        movieList {
            navController.navigateToDetails(it)
        }
        movieDetails {
            navController.navigateUp()
        }
    }
}
