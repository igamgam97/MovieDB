package com.noveogroup.moviecatalog.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun MovieError(
    error: String,
    onRefreshClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_network_error), contentDescription = "Something wrong")

        Text(text = error, fontSize = 24.sp)

        Button(onClick = onRefreshClicked, modifier = Modifier.padding(top = 25.dp)) {
            Text(text = stringResource(id = R.string.movie_list_refresh_button))
        }
    }
}

@Preview
@Composable
private fun MovieListErrorPreview() {
    MovieError("something wrong", {})
}
