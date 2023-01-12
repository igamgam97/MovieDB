package com.noveogroup.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noveogroup.moviecatalog.feature.moviedetail.presentation.screen.MovieDetailsRoute
import com.noveogroup.moviecatalog.feature.movielist.presentation.MovieListRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

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
                navigateToMovieDetails = { navController.navigate(Screen.MovieDetails.createRoute(it)) }
            )
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = Screen.MovieDetails.getArguments()
        ) { navBackStackEntry ->
            MovieDetailsRoute(
                onBackClick = { navController.navigateUp() },
                viewModel = koinViewModel() {
                    parametersOf(navBackStackEntry.arguments?.getLong(Screen.MovieDetails.getMoveId(), -1L))
                }
            )
        }
    }
}
