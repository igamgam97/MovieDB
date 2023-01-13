package com.noveogroup.moviecatalog.feature.movielist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.noveogroup.moviecatalog.feature.movielist.data.datasource.MoviePagingSource
import com.noveogroup.moviecatalog.feature.movielist.data.mapper.convert
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie
import com.noveogroup.moviecatalog.feature.movielist.domain.repository.MovieRepositoryApi
import com.noveogroup.moviecatalog.shared.configuration.data.datasource.ConfigurationDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MovieRepository(
    private val moviePagingSource: MoviePagingSource,
    private val configurationDataSource: ConfigurationDataSource
) : MovieRepositoryApi {

    override fun getPagingData(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = true),
            pagingSourceFactory = { moviePagingSource }
        ).flow
            .map {
                val smallPosterBaseUrl = configurationDataSource.loadSmallPosterBaseUrl().getOrNull() ?: ""
                it.map { movieResponse ->
                    movieResponse.convert(smallPosterBaseUrl)
                }
            }
    }
}
