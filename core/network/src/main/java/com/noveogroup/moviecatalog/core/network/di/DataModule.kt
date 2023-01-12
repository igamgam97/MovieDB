package com.noveogroup.moviecatalog.core.network.di

import com.noveogroup.moviecatalog.core.network.BuildConfig
import com.noveogroup.moviecatalog.core.network.data.network.adapter.LocalDateJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val restModule = module {

    factory {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().let { request ->
                        request.newBuilder().apply {
                            url(
                                request.url.newBuilder().addQueryParameter(
                                    "api_key",
                                    BuildConfig.API_KEY
                                ).build()
                            )
                        }.build()
                    }
                )
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(
                        if (BuildConfig.DEBUG) {
                            HttpLoggingInterceptor.Level.BODY
                        } else {
                            HttpLoggingInterceptor.Level.NONE
                        }
                    )
                }
            )
            .build()
    }

    factory {
        MoshiConverterFactory.create(
            Moshi.Builder()
                .add(LocalDateJsonAdapter())
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )
    }

    factory {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(get())
            .addConverterFactory(get<MoshiConverterFactory>())
            .build()
    }
}

val networkModule = module {

    includes(
        restModule,
        dispatchersModule
    )
}
