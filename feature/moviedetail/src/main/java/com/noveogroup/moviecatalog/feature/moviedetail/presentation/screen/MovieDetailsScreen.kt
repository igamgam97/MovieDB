package com.noveogroup.moviecatalog.feature.moviedetail.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.noveogroup.moviecatalog.core.designsystem.theme.TopAppBarTitle
import com.noveogroup.moviecatalog.feature.moviedetail.R
import com.noveogroup.moviecatalog.core.component.R as ComponentR

@Composable
fun MovieDetailsRoute(
    viewModel: MovieDetailsViewModel,
    onBackClick: () -> Unit
) {
    MovieDetailsScreen(
        onBackClick = onBackClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TopAppBarTitle(R.string.movie_details_title)
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(
                                id = ComponentR.string.common_content_description_back
                            )
                        )
                    }
                }
            )
        },
        content = { paddingValues ->

            MovieDetailsContent(
                paddingValues = paddingValues
            )
        }
    )
}

@Composable
fun MovieDetailsContent(
    paddingValues: PaddingValues
) {

}

@Composable
@Preview
fun MovieDetailsPreview() {
    MovieDetailsScreen(
        onBackClick = {}
    )
}