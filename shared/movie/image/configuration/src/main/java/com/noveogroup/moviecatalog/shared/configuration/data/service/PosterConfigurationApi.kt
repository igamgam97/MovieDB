package com.noveogroup.moviecatalog.shared.configuration.data.service

import com.noveogroup.moviecatalog.shared.configuration.data.model.ConfigurationResponse
import retrofit2.http.GET

interface PosterConfigurationApi {

    @GET("/3/configuration")
    suspend fun loadConfiguration(): ConfigurationResponse
}
