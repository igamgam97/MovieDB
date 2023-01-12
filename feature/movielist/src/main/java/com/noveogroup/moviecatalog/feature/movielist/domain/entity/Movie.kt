package com.noveogroup.moviecatalog.feature.movielist.domain.entity

data class Movie(
    val id: Long,
    val posterUrl: String,
    val rating: Float,
    val title: String
)
