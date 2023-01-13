package com.noveogroup.moviecatalog.feature.moviedetail.data.repository

import com.noveogroup.moviecatalog.feature.moviedetail.data.datasource.MovieDetailsDataSource
import com.noveogroup.moviecatalog.feature.moviedetail.data.mapper.convert
import com.noveogroup.moviecatalog.feature.moviedetail.data.model.MovieDetailsResponse
import com.noveogroup.moviecatalog.feature.moviedetail.domain.entity.MovieDetails
import com.noveogroup.moviecatalog.shared.configuration.data.datasource.ConfigurationDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.test.assertFailsWith

class MovieDetailsRepositoryTest {

    private val movieDetailsDataSource: MovieDetailsDataSource = mockk()
    private val configurationDataSource: ConfigurationDataSource = mockk()

    private lateinit var movieRepository: MovieDetailsRepository

    @Before
    fun setup() {
        movieRepository = MovieDetailsRepository(movieDetailsDataSource, configurationDataSource)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get film EXPECTED success`() {
        val id = 1L
        runTest {
            mockkStatic("com.noveogroup.moviecatalog.feature.moviedetail.data.mapper.MovieMapperKt")
            val movieDetailsResponse: MovieDetailsResponse = mockk()
            val movieDetails: MovieDetails = mockk()
            every { movieDetailsResponse.convert("") } returns movieDetails
            coEvery { movieDetailsDataSource.loadMovieDetails(id) } returns runCatching { movieDetailsResponse }
            coEvery { configurationDataSource.loadBigImageBaseUrl() } returns Result.success("")
            movieRepository.loadMovieDetails(1)
            coVerify { movieDetailsDataSource.loadMovieDetails(id) }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get load image error EXPECTED error`() {
        val id = 1L
        runTest {
            mockkStatic("com.noveogroup.moviecatalog.feature.moviedetail.data.mapper.MovieMapperKt")
            val movieDetailsResponse: MovieDetailsResponse = mockk()
            val movieDetails: MovieDetails = mockk()
            every { movieDetailsResponse.convert("") } returns movieDetails
            coEvery { movieDetailsDataSource.loadMovieDetails(id) } returns runCatching { movieDetailsResponse }
            coEvery { configurationDataSource.loadBigImageBaseUrl() } coAnswers { throw IOException() }
            assertFailsWith<IOException> { movieRepository.loadMovieDetails(id) }
        }
    }
}
