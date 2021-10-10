package com.soomgo.movieapp.data.data.repository

import com.soomgo.movieapp.data.data.dto.DetailResponse
import com.soomgo.movieapp.data.data.dto.MovieResponse
import com.soomgo.movieapp.data.data.dto.UpComingResponse
import com.soomgo.movieapp.data.data.local.MovieDAO
import com.soomgo.movieapp.data.data.network.Client
import com.soomgo.movieapp.domain.repository.model.Movie
import com.soomgo.movieapp.domain.repository.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(val client : Client, val dao : MovieDAO) : MovieRepository {
    override suspend fun fetchPopularMovie(): MovieResponse {
        return client.TmdbAPI.getPopularMovie()
    }

    override suspend fun fetchTopRatedMovie(): MovieResponse {
        return client.TmdbAPI.getTopRatedMovie()
    }

    override suspend fun fetchUpcomingMovie(): UpComingResponse {
        return client.TmdbAPI.getUpcomingMovie()
    }

    override suspend fun fetchDetailMovie(id: String): DetailResponse {
        return client.TmdbAPI.getDetailMovie()
    }

    override fun queryMovies(): Flow<List<Movie>> {
        return dao.getMovie()
    }

    override suspend fun queryMovie(movie: Movie): Flow<Movie> {
        return dao.getMovieById(movie.id)
    }

    override suspend fun insertMovie(movie: Movie) {
        return dao.InsertMovie(movie)
    }

    override suspend fun deleteMovie(movie: Movie) {
        return dao.DeleteMovie(movie)
    }
}