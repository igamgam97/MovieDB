package com.noveogroup.moviecatalog.feature.movielist.data.api

import com.noveogroup.moviecatalog.feature.movielist.data.model.MovieResponse
import com.noveogroup.moviecatalog.feature.movielist.data.model.PagedResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieApi {

    @GET("/3/discover/movie")
    suspend fun loadMovies(
        @Query("page") page: Int,
        @Query("language") language: String
    ): PagedResponse<MovieResponse>
}
