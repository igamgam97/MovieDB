package com.noveogroup.moviecatalog.feature.moviedetail.data.repository

import com.noveogroup.moviecatalog.core.component.data.datasource.ConfigurationDataSource
import com.noveogroup.moviecatalog.feature.moviedetail.data.datasource.MovieDetailsDataSource
import com.noveogroup.moviecatalog.feature.moviedetail.data.mapper.convert
import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails
import com.noveogroup.moviecatalog.feature.moviedetail.domain.repository.MoviesRepositoryApi

internal class MovieDetailsRepository(
    private val movieDetailsDataSource: MovieDetailsDataSource,
    private val configurationDataSource: ConfigurationDataSource
) : MoviesRepositoryApi {

    override suspend fun loadMovieDetails(id: Long): Result<MovieDetails> {
        return movieDetailsDataSource.loadMovieDetails(id).map {
            val bigImageBaseUrl = configurationDataSource.loadBigImageBaseUrl().getOrNull() ?: ""
            it.convert(bigImageBaseUrl)
        }
    }
}
