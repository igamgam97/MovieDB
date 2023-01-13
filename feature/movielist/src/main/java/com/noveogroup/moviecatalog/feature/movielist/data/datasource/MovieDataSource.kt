package com.noveogroup.moviecatalog.feature.movielist.data.datasource

import com.noveogroup.moviecatalog.feature.movielist.data.api.MovieApi
import com.noveogroup.moviecatalog.feature.movielist.data.model.MovieResponse
import com.noveogroup.moviecatalog.feature.movielist.data.model.PagedResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*

internal class MovieDataSource(
    private val movieApi: MovieApi,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun loadMovies(page: Int): PagedResponse<MovieResponse> {
        return withContext(ioDispatcher) {
            val lang = Locale.getDefault().toLanguageTag()
            movieApi.loadMovies(page, lang)
        }
    }
}
