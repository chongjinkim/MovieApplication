package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.repository.MovieRepository

class QueryFavoritesUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke() = repository.queryMovies()
}