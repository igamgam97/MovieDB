package com.noveogroup.moviedb.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String) {

    object MovieList : Screen("movie_list")

    object MovieDetails : Screen("movie_details/{movieId}") {

        fun getArguments() = listOf(navArgument(getMoveId()) { type = NavType.LongType })

        fun createRoute(movieId: Long) =
            "movie_details/$movieId"

        fun getMoveId(): String = "movieId"
    }
}
