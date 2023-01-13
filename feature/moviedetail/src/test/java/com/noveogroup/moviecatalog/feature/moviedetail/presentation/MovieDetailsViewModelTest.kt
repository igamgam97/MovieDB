package com.noveogroup.moviecatalog.feature.moviedetail.presentation

import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails
import com.noveogroup.moviecatalog.feature.moviedetail.domain.usecase.GetMovieDetailsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import kotlin.test.assertTrue

class MovieDetailsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getMovieDetails: GetMovieDetailsUseCase = mockk()

    private val movieDetails: MovieDetails = mockk()

    private lateinit var viewModel: MovieDetailsViewModel

    private val movieId = 1L

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get result EXPECTED state successful`() = runTest {
        coEvery { getMovieDetails.invoke(movieId) } returns Result.success(movieDetails)
        viewModel = MovieDetailsViewModel(movieId, getMovieDetails)

        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.state.collect() }

        assertTrue { viewModel.state.value is MovieDetailsScreenState.Success }

        collectJob.cancel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get error EXPECTED state error`() = runTest {
        coEvery { getMovieDetails.invoke(movieId) } returns Result.failure(IOException())
        viewModel = MovieDetailsViewModel(movieId, getMovieDetails)

        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.state.collect() }

        assertTrue { viewModel.state.value is MovieDetailsScreenState.Error }

        collectJob.cancel()
    }
}
