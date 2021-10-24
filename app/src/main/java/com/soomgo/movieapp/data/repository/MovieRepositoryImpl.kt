package com.soomgo.movieapp.data.repository

import com.soomgo.movieapp.data.dto.DetailResponse
import com.soomgo.movieapp.data.dto.MovieResponse
import com.soomgo.movieapp.data.dto.UpComingResponse
import com.soomgo.movieapp.data.local.MovieDAO
import com.soomgo.movieapp.data.network.Client
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow


class MovieRepositoryImpl(val client : Client, val dao : MovieDAO) : MovieRepository {


    override suspend fun fetchPopularMovie() = client.TmdbAPI.getPopularMovie()

    override suspend fun fetchTopRatedMovie() = client.TmdbAPI.getTopRatedMovie()

    override suspend fun fetchUpcomingMovie() = client.TmdbAPI.getUpcomingMovie()

    override suspend fun fetchDetailMovie(id: String) = client.TmdbAPI.getDetailMovie(id)

    override fun queryMovies(): Flow<List<Movie>> = dao.getMovies()

    override suspend fun queryMovie(movie: Movie) =  dao.getMovieById(movie.id)

    override suspend fun insertMovie(movie: Movie) = dao.InsertMovie(movie)

    override suspend fun deleteMovie(movie: Movie)  = dao.DeleteMovie(movie)


}