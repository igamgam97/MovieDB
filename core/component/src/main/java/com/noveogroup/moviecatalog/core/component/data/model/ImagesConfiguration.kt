package com.noveogroup.moviecatalog.core.component.data.model

import com.squareup.moshi.Json

data class ImagesConfiguration(
    @Json(name = "secure_base_url")
    val secureBaseUrl: String,
    @Json(name = "poster_sizes")
    val posterSizes: List<String>
)
