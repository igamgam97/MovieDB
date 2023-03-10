package com.noveogroup.moviecatalog.shared.configuration.data.datasource

import com.noveogroup.moviecatalog.shared.configuration.data.model.ConfigurationResponse
import com.noveogroup.moviecatalog.shared.configuration.data.service.PosterConfigurationApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ConfigurationDataSource(
    private val posterConfigurationApi: PosterConfigurationApi,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun loadSmallPosterBaseUrl(): Result<String> {
        return getConfiguration()
            .map { it.imagesConfig }
            .map { it.secureBaseUrl + it.posterSizes.first() }
    }

    suspend fun loadBigImageBaseUrl(): Result<String> =
        getConfiguration()
            .map { it.imagesConfig }
            .map { it.secureBaseUrl + it.posterSizes.last() }

    private suspend fun getConfiguration(): Result<ConfigurationResponse> {
        return withContext(ioDispatcher) {
            runCatching {
                posterConfigurationApi.loadConfiguration()
            }
        }
    }
}
