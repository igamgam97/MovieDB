package com.noveogroup.moviecatalog.core.network.data.network.model

import com.noveogroup.moviecatalog.feature.moviedetail.data.model.GenreResponse
import com.squareup.moshi.Json

data class GenreListResponse(
    @Json(name = "genres")
    val genres: List<GenreResponse>
)
