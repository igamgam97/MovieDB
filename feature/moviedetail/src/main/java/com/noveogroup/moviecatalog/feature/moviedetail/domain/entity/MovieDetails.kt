package com.noveogroup.moviecatalog.feature.moviedetail.domain.entity

import java.time.LocalDate

data class MovieDetails(
    val id: Long,
    val posterUrl: String,
    val rating: Float,
    val voteCount: Int,
    val title: String,
    val originalTitle: String,
    val genres: List<String>,
    val overview: String,
    val releaseDate: LocalDate?

)
