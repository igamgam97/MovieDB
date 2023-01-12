package com.noveogroup.moviecatalog.core.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.SubcomposeAsyncImage

@Composable
fun MoviePoster(modifier: Modifier, posterUrl: String) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = posterUrl,
        contentDescription = stringResource(id = R.string.common_content_description_poster),
        loading = {
            MoviePosterPlaceholder()
        },
        error = {
            MoviePosterPlaceholder()
        }
    )
}

@Composable
fun MoviePosterPlaceholder() {
    Image(
        painter = painterResource(id = R.drawable.ic_movie_poster_placeholder),
        contentDescription = stringResource(
            id = R.string.common_content_description_poster_placeholder
        ),
        colorFilter = ColorFilter.tint(Color.LightGray)
    )
}
