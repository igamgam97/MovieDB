package com.noveogroup.moviecatalog.core.component.data.service

import com.noveogroup.moviecatalog.core.component.data.model.ConfigurationResponse
import retrofit2.http.GET

interface PosterConfigurationApi {

    @GET("/3/configuration")
    suspend fun loadConfiguration(): ConfigurationResponse
}
