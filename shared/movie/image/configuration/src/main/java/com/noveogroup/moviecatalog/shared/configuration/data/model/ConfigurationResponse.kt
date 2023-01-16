package com.noveogroup.moviecatalog.shared.configuration.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConfigurationResponse(
    @Json(name = "images")
    val imagesConfig: ImagesConfiguration
)
