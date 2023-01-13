package com.noveogroup.moviecatalog.core.component.di

import com.noveogroup.moviecatalog.shared.configuration.data.datasource.ConfigurationDataSource
import com.noveogroup.moviecatalog.shared.configuration.data.service.PosterConfigurationApi
import org.koin.dsl.module
import retrofit2.Retrofit

val configurationModule = module {

    factory { get<Retrofit>().create(PosterConfigurationApi::class.java) }

    single { ConfigurationDataSource(posterConfigurationApi = get(), ioDispatcher = get()) }
}
