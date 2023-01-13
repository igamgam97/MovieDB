package com.noveogroup.moviecatalog.feature.movielist.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel

const val movieListRoute = "movie_list"

fun NavGraphBuilder.movieList(navigateToMovieDetails: (Long) -> Unit) {
    composable(route = movieListRoute) {
        MovieListRoute(viewModel = koinViewModel(), navigateToMovieDetails = navigateToMovieDetails)
    }
}
