package com.noveogroup.moviecatalog.feature.moviedetail.data.model

import com.squareup.moshi.Json

internal data class GenreResponse(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String
)
