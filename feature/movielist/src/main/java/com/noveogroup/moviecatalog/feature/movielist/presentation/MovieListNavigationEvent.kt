package com.noveogroup.moviecatalog.feature.movielist.presentation

sealed class MovieListNavigationEvent {

    data class MovieDetailsScreen(val movieId: Long) : MovieListNavigationEvent()
}
