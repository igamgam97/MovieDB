package com.noveogroup.moviecatalog.feature.movielist.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.noveogroup.moviecatalog.core.component.MoviePoster
import com.noveogroup.moviecatalog.core.designsystem.theme.AppTheme
import com.noveogroup.moviecatalog.core.designsystem.theme.TopAppBarTitle
import com.noveogroup.moviecatalog.feature.movielist.R
import com.noveogroup.moviecatalog.feature.movielist.domain.entity.Movie
import kotlinx.coroutines.flow.flowOf

@Composable
fun MovieListRoute(
    navController: NavController,
    viewModel: MovieListViewModel
) {

    MovieListScreen(
        viewModel.items.collectAsLazyPagingItems(),
        onItemClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieListScreen(
    movies: LazyPagingItems<Movie>,
    onItemClicked: (Movie) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                TopAppBarTitle(R.string.movie_list_title)
            })
        },
        content = { paddingValues ->
            MovieListContent(paddingValues, movies, onItemClicked)
        }
    )
}

@Composable
private fun MovieListContent(
    paddingValues: PaddingValues,
    movies: LazyPagingItems<Movie>,
    onItemClicked: (Movie) -> Unit
) {
    val lazyListState = rememberLazyListState()
    Box {
        LazyColumn(
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = paddingValues
        ) {
            items(
                items = movies,
                key = { it.id }
            )  {
                if (it != null) {
                    MovieListItemView(
                        movie = it,
                        onClicked = onItemClicked
                    )
                }
            }
        }
    }
}

@Composable
private fun MovieListItemView(
    movie: Movie,
    onClicked: (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onClicked(movie)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoviePoster(
            modifier = Modifier
                .weight(1f)
                .height(100.dp),
            posterUrl = movie.posterUrl
        )

        Column(
            modifier = Modifier
                .weight(3f)
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            MovieTitle(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .weight(1.0f),
                title = movie.title
            )
        }
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
            fontSize = 16.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun MovieListPreview() {
    val usersFlow = flowOf(
        PagingData.from(
            listOf(
                Movie(0L, "", 5.0f, "Titanic"),
                Movie(
                    1L,
                    "",
                    9.0f,
                    "Night of the Day of the Dawn of the Son of the Bride of the Return of the Revenge of the Terror of the Attack of the Evil Mutant Hellbound Flesh Eating Crawling Alien Zombified Subhumanoid Living Dead, Part 5"
                )
            )
        )
    )
    MovieListScreen(
        movies = usersFlow.collectAsLazyPagingItems(),
        onItemClicked = {}
    )
}

@Preview
@Composable
private fun MoviePreview() {
    AppTheme {
        val movie = Movie(
            2L,
            "",
            9.0f,
            "Night of the of the Son of the Bride of the"
        )
        MovieListItemView(movie, {})
    }
}