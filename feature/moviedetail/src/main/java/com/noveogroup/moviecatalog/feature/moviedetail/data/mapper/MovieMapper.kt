package com.noveogroup.moviecatalog.feature.moviedetail.data.mapper

import com.noveogroup.moviecatalog.feature.moviedetail.data.model.MovieDetailsResponse
import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails

internal fun MovieDetailsResponse.convert(baseImageUrl: String): MovieDetails {
    return MovieDetails(
        id = id,
        posterUrl = "$baseImageUrl$posterPath",
        rating = voteAverage ?: 0f,
        voteCount = voteCount ?: 0,
        title = title ?: originalTitle ?: "",
        originalTitle = originalTitle ?: "",
        genres = genres.map { it.name },
        overview = overview ?: "",
        releaseDate = releaseDate
    )
}
