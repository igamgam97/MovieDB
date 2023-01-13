package com.noveogroup.moviecatalog.shared.configuration.data.model

import com.squareup.moshi.Json

data class ConfigurationResponse(
    @Json(name = "images")
    val imagesConfig: ImagesConfiguration
)
