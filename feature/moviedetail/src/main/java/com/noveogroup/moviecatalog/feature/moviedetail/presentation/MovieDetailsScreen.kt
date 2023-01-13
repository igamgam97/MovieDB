package com.noveogroup.moviecatalog.feature.moviedetail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.noveogroup.moviecatalog.core.component.MovieError
import com.noveogroup.moviecatalog.core.designsystem.theme.TopAppBarTitle
import com.noveogroup.moviecatalog.feature.moviedetail.R
import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails
import java.time.LocalDate
import com.noveogroup.moviecatalog.core.component.R as ComponentR

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MovieDetailsRoute(
    viewModel: MovieDetailsViewModel,
    onBackClick: () -> Unit
) {
    MovieDetailsScreen(
        state = viewModel.state.collectAsStateWithLifecycle().value,
        onBackClick = onBackClick,
        onRefreshClick = viewModel::refresh
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    state: MovieDetailsScreenState,
    onBackClick: () -> Unit,
    onRefreshClick: () -> Unit
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

            when (state) {
                is MovieDetailsScreenState.Error -> MovieError(error = state.message ?: "", onRefreshClicked = { onRefreshClick() })
                MovieDetailsScreenState.Loading ->  MovieDetailsLoading()
                is MovieDetailsScreenState.Success -> {
                    MovieDetailsContent(
                        paddingValues = paddingValues,
                        state.movieDetails
                    )
                }
            }
        }
    )
}

@Composable
fun MovieDetailsLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MovieDetailsContent(
    paddingValues: PaddingValues,
    movieDetails: MovieDetails
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MovieTitle(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            title = movieDetails.title
        )
    }
}

@Composable
private fun MovieTitle(
    modifier: Modifier,
    title: String
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview
fun MovieDetailsPreview() {
    val state = MovieDetailsScreenState.Success(
        MovieDetails(
            id = 10L,
            posterUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3ayWL13P1HeRnyVL9lU9flOdZjq.jpg",
            rating = 8.654f,
            voteCount = 1000,
            title = "Night of the Day of the Dawn of the Son of the Bride of the Return of the Revenge of the Terror of the Attack of the Evil Mutant Hellbound Flesh Eating Crawling Alien Zombified Subhumanoid Living Dead, Part 5",
            originalTitle = "Original title",
            genres = listOf("Drama", "Horror", "Horror"),
            overview = "Following the dumping of gallons of toxic waste in the river, a giant mutated squid-like creature appears and begins attacking the populace. Gang-du's daughter Hyun-seo is snatched up by the creature; with his family to assist him, he sets off to find her.",
            releaseDate = LocalDate.parse("2000-01-01")
        )
    )
    MovieDetailsScreen(
        state = state,
        onBackClick = {},
        onRefreshClick = {}
    )
}