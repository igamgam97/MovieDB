package com.noveogroup.moviecatalog.feature.moviedetail.di

import com.noveogroup.moviecatalog.core.component.di.configurationModule
import com.noveogroup.moviecatalog.core.network.di.networkModule
import com.noveogroup.moviecatalog.feature.moviedetail.data.api.MovieDetailsApi
import com.noveogroup.moviecatalog.feature.moviedetail.data.datasource.MovieDetailsDataSource
import com.noveogroup.moviecatalog.feature.moviedetail.data.repository.MovieDetailsRepository
import com.noveogroup.moviecatalog.feature.moviedetail.domain.repository.MoviesRepositoryApi
import com.noveogroup.moviecatalog.feature.moviedetail.domain.usecase.GetMovieDetailsUseCase
import com.noveogroup.moviecatalog.feature.moviedetail.presentation.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val movieDetailsModule = module {

    includes(configurationModule)
    includes(networkModule)

    factory { get<Retrofit>().create(MovieDetailsApi::class.java) }

    factory { MovieDetailsDataSource(movieDetailsApi = get(), ioDispatcher = get()) }

    factory<MoviesRepositoryApi> {
        MovieDetailsRepository(
            movieDetailsDataSource = get(),
            configurationDataSource = get()
        )
    }

    factory { GetMovieDetailsUseCase(repository = get()) }

    viewModel { parameters ->
        MovieDetailsViewModel(
            movieId = parameters.get(),
            getMovieDetails = get()
        )
    }
}
