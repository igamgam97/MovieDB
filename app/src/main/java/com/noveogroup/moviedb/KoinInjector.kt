package com.noveogroup.moviedb

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

object KoinInjector {

    fun inject(app: App) {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.INFO)
            androidContext(app)
        }
    }
}
