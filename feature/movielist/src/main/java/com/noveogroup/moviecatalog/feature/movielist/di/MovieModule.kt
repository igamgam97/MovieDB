package com.noveogroup.moviecatalog.feature.movielist.di
import com.noveogroup.moviecatalog.feature.movielist.presentation.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    viewModel {
        MovieListViewModel()
    }
}
