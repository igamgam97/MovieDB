package com.noveogroup.moviecatalog.feature.movielist.data.mapper

import com.noveogroup.moviecatalog.feature.movielist.data.model.MovieResponse
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie

fun MovieResponse.convert(imageBasePath: String): Movie {
    return Movie(
        id = id,
        rating = voteAverage ?: 0f,
        posterUrl = "$imageBasePath$posterPath",
        title = title ?: originalTitle ?: ""
    )
}
