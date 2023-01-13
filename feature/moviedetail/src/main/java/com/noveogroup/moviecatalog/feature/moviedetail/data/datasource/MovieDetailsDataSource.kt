package com.noveogroup.moviecatalog.feature.moviedetail.data.datasource

import com.noveogroup.moviecatalog.feature.moviedetail.data.api.MovieDetailsApi
import com.noveogroup.moviecatalog.feature.moviedetail.data.model.MovieDetailsResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*

internal class MovieDetailsDataSource(
    private val movieDetailsApi: MovieDetailsApi,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun loadMovieDetails(movieId: Long): Result<MovieDetailsResponse> {
        return withContext(ioDispatcher) {
            runCatching {
                val lang = Locale.getDefault().toLanguageTag()
                movieDetailsApi.loadMovieDetails(movieId, lang)
            }
        }
    }
}
