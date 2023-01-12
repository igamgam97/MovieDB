package com.noveogroup.moviecatalog.feature.movielist.domain.repository

import androidx.paging.PagingData
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepositoryApi {

    fun getPagingData(): Flow<PagingData<Movie>>
}
