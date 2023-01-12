package com.noveogroup.moviedb.navigation

sealed class Screen(val route: String) {

    object MovieList : Screen("movie_list")
}
