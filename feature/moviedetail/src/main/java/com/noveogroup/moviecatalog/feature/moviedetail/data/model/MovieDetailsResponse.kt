package com.noveogroup.moviecatalog.feature.moviedetail.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate

@JsonClass(generateAdapter = true)
internal data class MovieDetailsResponse(
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "release_date")
    val releaseDate: LocalDate?,
    @Json(name = "id")
    val id: Long,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "vote_count")
    val voteCount: Int?,
    @Json(name = "vote_average")
    val voteAverage: Float?,
    @Json(name = "genres")
    val genres: List<GenreResponse>
)
