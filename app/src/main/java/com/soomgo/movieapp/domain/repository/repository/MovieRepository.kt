package com.soomgo.movieapp.domain.repository.repository

import com.soomgo.movieapp.data.data.dto.DetailResponse
import com.soomgo.movieapp.data.data.dto.MovieResponse
import com.soomgo.movieapp.data.data.dto.UpComingResponse
import com.soomgo.movieapp.domain.repository.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun fetchPopularMovie() : MovieResponse
    suspend fun fetchTopRatedMovie() : MovieResponse
    suspend fun fetchUpcomingMovie() : UpComingResponse
    suspend fun fetchDetailMovie(id : String) : DetailResponse

    fun queryMovies() : Flow<List<Movie>>
    suspend fun queryMovie(movie : Movie) : Flow<Movie>
    suspend fun insertMovie(movie : Movie)
    suspend fun deleteMovie(movie : Movie)

}