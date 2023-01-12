package com.noveogroup.moviecatalog.feature.moviedetail.di

import com.noveogroup.moviecatalog.feature.moviedetail.presentation.screen.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {

    viewModel { parameters ->
        MovieDetailsViewModel(
            movieId = parameters.get()
        )
    }
}
