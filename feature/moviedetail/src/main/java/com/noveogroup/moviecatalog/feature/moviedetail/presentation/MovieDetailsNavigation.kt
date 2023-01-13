package com.noveogroup.moviecatalog.feature.moviedetail.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

const val detailsMovieRoute = "movie_details/{movieId}"
private const val movieId = "movieId"

fun NavController.navigateToDetails(movieId: Long) {
    navigate("movie_details/$movieId")
}

fun NavGraphBuilder.movieDetails(onBackClick: () -> Unit) {
    composable(
        route = detailsMovieRoute,
        arguments = listOf(navArgument(movieId) { type = NavType.LongType })
    ) { navBackStackEntry ->
        MovieDetailsRoute(
            onBackClick = { onBackClick() },
            viewModel = koinViewModel() {
                parametersOf(navBackStackEntry.arguments?.getLong(movieId, -1L))
            }
        )
    }
}
