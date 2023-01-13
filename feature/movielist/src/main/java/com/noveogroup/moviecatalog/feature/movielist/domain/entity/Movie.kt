package com.noveogroup.moviecatalog.feature.movielist.domain.entity

internal data class Movie(
    val id: Long,
    val posterUrl: String,
    val rating: Float,
    val title: String
)
