package com.noveogroup.moviecatalog.feature.moviedetail.domain.repository

import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails

interface MoviesRepositoryApi {

    suspend fun loadMovieDetails(id: Long): Result<MovieDetails>
}
