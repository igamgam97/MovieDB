package com.noveogroup.moviecatalog.shared.configuration.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesConfiguration(
    @Json(name = "secure_base_url")
    val secureBaseUrl: String,
    @Json(name = "poster_sizes")
    val posterSizes: List<String>
)
