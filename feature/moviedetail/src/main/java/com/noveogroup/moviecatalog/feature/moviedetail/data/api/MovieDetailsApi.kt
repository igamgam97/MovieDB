package com.noveogroup.moviecatalog.feature.moviedetail.data.api

import com.noveogroup.moviecatalog.feature.moviedetail.data.model.MovieDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {

    @GET("/3/movie/{movieId}")
    suspend fun loadMovieDetails(
        @Path("movieId") movieId: Long,
        @Query("language") language: String
    ): MovieDetailsResponse
}
