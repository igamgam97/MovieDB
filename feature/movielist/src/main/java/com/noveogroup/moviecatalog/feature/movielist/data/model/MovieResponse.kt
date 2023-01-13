package com.noveogroup.moviecatalog.feature.movielist.data.model

import com.squareup.moshi.Json
import java.time.LocalDate

internal data class MovieResponse(
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "release_date")
    val releaseDate: LocalDate?,
    @Json(name = "genre_ids")
    val genreIds: List<Long>?,
    @Json(name = "id")
    val id: Long,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "vote_average")
    val voteAverage: Float?
)
