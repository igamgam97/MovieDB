package com.noveogroup.moviecatalog.feature.movielist.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.noveogroup.moviecatalog.feature.movielist.data.model.MovieResponse

internal class MoviePagingSource(
    private val movieDataSource: MovieDataSource
) : PagingSource<Int, MovieResponse>() {

    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResponse> =
        try {
            val nextPage = params.key ?: 1
            val userList = movieDataSource.loadMovies(nextPage)
            LoadResult.Page(
                data = userList.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (userList.results.isEmpty()) null else userList.page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
}
