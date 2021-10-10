package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.repository.MovieRepository

class InsertMovieUseCase(private val repository : MovieRepository) {

    suspend operator fun invoke(movie : Movie) = repository.insertMovie(movie)
}