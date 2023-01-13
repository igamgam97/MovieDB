package com.noveogroup.moviecatalog.feature.moviedetail.presentation

import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails

sealed class MovieDetailsScreenState {

    object Loading : MovieDetailsScreenState()

    class Error(val message: String?) : MovieDetailsScreenState()

    class Success(val movieDetails: MovieDetails) : MovieDetailsScreenState()
}
