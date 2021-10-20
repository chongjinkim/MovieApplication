package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.map

class QueryFavoritesUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke() = repository.queryMovies()
}