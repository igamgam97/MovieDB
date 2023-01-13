package com.noveogroup.moviecatalog.feature.moviedetail.domain.usecase

import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails
import com.noveogroup.moviecatalog.feature.moviedetail.domain.repository.MoviesRepositoryApi

internal class GetMovieDetailsUseCase(
    private val repository: MoviesRepositoryApi
) {

    suspend operator fun invoke(id: Long): Result<MovieDetails> {
        return repository.loadMovieDetails(id)
    }
}
