package com.soomgo.movieapp.domain.usecase

import com.soomgo.movieapp.common.Resource
import com.soomgo.movieapp.data.dto.toMovie
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class PopularMovieUseCase(private val repository : MovieRepository) {

    operator fun invoke() : Flow<Resource<List<Movie>>> = flow {

        try {
            emit(Resource.Loading())
            val movies = repository.fetchPopularMovie().results.map { it.toMovie() }
            emit(Resource.Success(movies))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection."))
        }

    }
}