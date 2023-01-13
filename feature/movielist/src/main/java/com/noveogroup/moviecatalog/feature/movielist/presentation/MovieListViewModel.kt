package com.noveogroup.moviecatalog.feature.movielist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie
import com.noveogroup.moviecatalog.feature.movielist.domain.usecase.GetMoviePagingDataUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

internal class MovieListViewModel(
    getMoviePagingData: GetMoviePagingDataUseCase
) : ViewModel() {

    private val _navigationEvents = MutableSharedFlow<MovieListNavigationEvent>()
    val navigationEvents = _navigationEvents.asSharedFlow()

    val items: Flow<PagingData<Movie>> = getMoviePagingData()
        .cachedIn(viewModelScope)

    fun handleMovieClicked(movie: Movie) {
        viewModelScope.launch {
            _navigationEvents.emit(MovieListNavigationEvent.MovieDetailsScreen(movie.id))
        }
    }
}
