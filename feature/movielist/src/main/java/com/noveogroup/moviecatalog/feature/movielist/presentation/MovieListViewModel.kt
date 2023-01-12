package com.noveogroup.moviecatalog.feature.movielist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie
import com.noveogroup.moviecatalog.feature.movielist.domain.usecase.GetMoviePagingDataUseCase
import kotlinx.coroutines.flow.Flow

class MovieListViewModel(
    getMoviePagingData: GetMoviePagingDataUseCase
) : ViewModel() {

    val items: Flow<PagingData<Movie>> = getMoviePagingData()
        .cachedIn(viewModelScope)
}
