package com.noveogroup.moviecatalog.core.component.data.model

import com.squareup.moshi.Json

data class ConfigurationResponse(
    @Json(name = "images")
    val imagesConfig: ImagesConfiguration
)
