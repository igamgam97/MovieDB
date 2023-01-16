package com.noveogroup.moviecatalog.feature.movielist.di
import com.noveogroup.moviecatalog.core.network.di.networkModule
import com.noveogroup.moviecatalog.feature.movielist.data.api.MovieApi
import com.noveogroup.moviecatalog.feature.movielist.data.datasource.MovieDataSource
import com.noveogroup.moviecatalog.feature.movielist.data.datasource.MoviePagingSource
import com.noveogroup.moviecatalog.feature.movielist.data.repository.MovieRepository
import com.noveogroup.moviecatalog.feature.movielist.domain.repository.MovieRepositoryApi
import com.noveogroup.moviecatalog.feature.movielist.domain.usecase.GetMoviePagingDataUseCase
import com.noveogroup.moviecatalog.feature.movielist.presentation.MovieListViewModel
import com.noveogroup.moviecatalog.shared.configuration.di.configurationModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val movieModule = module {

    includes(networkModule)
    includes(configurationModule)

    factory { get<Retrofit>().create(MovieApi::class.java) }

    factory { MovieDataSource(movieApi = get(), ioDispatcher = get()) }

    factory { MoviePagingSource(movieDataSource = get()) }

    factory<MovieRepositoryApi> {
        MovieRepository(
            moviePagingSource = get(),
            configurationDataSource = get()
        )
    }

    factory { GetMoviePagingDataUseCase(newRepository = get()) }

    viewModel {
        MovieListViewModel(
            getMoviePagingData = get()
        )
    }
}
