package com.soomgo.movieapp.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.usecase.PopularMovieUseCase
import com.soomgo.movieapp.domain.usecase.TopRatedMovieUseCase
import com.soomgo.movieapp.domain.usecase.UpcomingMovieUseCase
import kotlinx.coroutines.flow.collectLatest

class MovieViewModel(private val popularMovieUseCase: PopularMovieUseCase,
                     private val topRatedMovieUseCase: TopRatedMovieUseCase,
                     private val upcomingMovieUseCase: UpcomingMovieUseCase) : ViewModel(){

    val popularMovies : LiveData<List<Movie>?> = liveData {
        popularMovieUseCase.invoke().collectLatest {
            emit(it.data)
        }
    }

    val topRateMovies : LiveData<List<Movie>?> = liveData {
        topRatedMovieUseCase.invoke().collectLatest {
            emit(it.data)
        }
    }

    val upcomingMovies : LiveData<List<Movie>?> = liveData {
        upcomingMovieUseCase.invoke().collectLatest {
            emit(it.data)
        }
    }

}