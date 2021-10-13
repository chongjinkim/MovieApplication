package com.soomgo.movieapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.model.MovieDetail
import com.soomgo.movieapp.domain.usecase.DetailMovieUseCase
import com.soomgo.movieapp.domain.usecase.InsertMovieUseCase
import com.soomgo.movieapp.domain.usecase.QueryFavoritesUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailViewModel(private val detailMovieUseCase: DetailMovieUseCase,
                      val insertMovieUseCase: InsertMovieUseCase,
                      val deleteMovieUseCase : DetailMovieUseCase,
                      val queryFavoritesUseCase: QueryFavoritesUseCase ) :  ViewModel(){


    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail>
        get() = _movieDetail

    private val _movieFavorite = MutableLiveData(false)
    val moiveFavorite : LiveData<Boolean>
        get() = _movieFavorite

    fun fetchDetail(movie : Movie){
        viewModelScope.launch {

            launch {
                queryFavoritesUseCase().collectLatest {
                    _movieFavorite.value = true
                }
            }

          detailMovieUseCase.invoke(movie).collectLatest { movieDetail ->
              movieDetail.data?.let {
                  _movieDetail.value = it
              }
          }
        }
    }
}

