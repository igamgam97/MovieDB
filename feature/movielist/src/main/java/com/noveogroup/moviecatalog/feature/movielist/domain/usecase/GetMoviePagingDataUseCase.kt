package com.noveogroup.moviecatalog.feature.movielist.domain.usecase

import androidx.paging.PagingData
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie
import com.noveogroup.moviecatalog.feature.movielist.domain.repository.MovieRepositoryApi
import kotlinx.coroutines.flow.Flow

class GetMoviePagingDataUseCase(
    private val newRepository: MovieRepositoryApi
) {

    operator fun invoke(): Flow<PagingData<Movie>> =
        newRepository.getPagingData()
}
