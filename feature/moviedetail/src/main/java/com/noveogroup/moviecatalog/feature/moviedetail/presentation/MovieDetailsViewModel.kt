package com.noveogroup.moviecatalog.feature.moviedetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noveogroup.moviecatalog.feature.moviedetail.domain.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieId: Long,
    private val getMovieDetails: GetMovieDetailsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<MovieDetailsScreenState> =
        MutableStateFlow(MovieDetailsScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        getMovieDetails()
    }

    fun refresh() {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            getMovieDetails(movieId).let { result ->
                _state.update {
                    if (result.isSuccess) {
                        MovieDetailsScreenState.Success(result.getOrThrow())
                    } else {
                        MovieDetailsScreenState.Error(
                            result.exceptionOrNull()?.localizedMessage
                        )
                    }
                }
            }
        }
    }
}
