package com.noveogroup.moviecatalog.feature.movielist.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.noveogroup.moviecatalog.core.designsystem.theme.TopAppBarTitle
import com.noveogroup.moviecatalog.feature.movielist.R

@Composable
fun MovieListRoute(
    navController: NavController,
    viewModel: MovieListViewModel
) {

    MovieListScreen(
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieListScreen(
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                TopAppBarTitle(R.string.movie_list_title)
            })
        },
        content = { paddingValues ->
            MovieListContent(paddingValues)
        }
    )
}

@Composable
private fun MovieListContent(paddingValues: PaddingValues){
}

@Preview
@Composable
private fun MovieListPreview() {
    MovieListScreen(
    )
}