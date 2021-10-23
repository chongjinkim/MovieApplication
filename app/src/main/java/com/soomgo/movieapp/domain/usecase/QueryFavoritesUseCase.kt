package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.map


class QueryFavoritesUseCase(private val repository: MovieRepository) {
//dao
    suspend operator fun invoke() = repository.queryMovies()
}