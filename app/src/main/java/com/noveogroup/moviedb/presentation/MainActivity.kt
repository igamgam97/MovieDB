package com.noveogroup.moviedb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.noveogroup.moviecatalog.core.designsystem.theme.AppTheme
import com.noveogroup.moviedb.navigation.MovieCatalogNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MovieCatalogNavHost()
            }
        }
    }
}
