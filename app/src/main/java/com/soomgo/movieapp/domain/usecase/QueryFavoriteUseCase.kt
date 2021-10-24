package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.model.MovieDetail
import com.soomgo.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class QueryFavoriteUseCase(private val repository : MovieRepository) {
//dao
    suspend operator fun invoke(movie : Movie) = repository.queryMovie(movie)

}