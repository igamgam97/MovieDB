package com.noveogroup.moviecatalog.feature.movielist.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PagedResponse<T>(
    @Json(name = "page")
    val page: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalItems: Int,
    @Json(name = "results")
    val results: List<T>
)
