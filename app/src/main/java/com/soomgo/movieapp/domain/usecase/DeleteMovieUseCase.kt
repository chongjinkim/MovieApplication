package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.repository.MovieRepository

class DeleteMovieUseCase(private val repository : MovieRepository) {
//dao
    suspend operator fun invoke(movie : Movie){
        repository.deleteMovie(movie)
    }

}