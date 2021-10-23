package com.soomgo.movieapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.domain.model.MovieDetail
import com.soomgo.movieapp.domain.usecase.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//매개변수로 각각 useCase활용
class DetailViewModel(private val detailMovieUseCase: DetailMovieUseCase,
                      val insertMovieUseCase: InsertMovieUseCase,
                      val deleteMovieUseCase : DeleteMovieUseCase,
                      val queryFavoriteUseCase: QueryFavoriteUseCase
) :  ViewModel(){


    //moviedetail 및 favorite 라이브 데이터 구현
    //mutablelivedata, livedata -> movieDetail 활용
    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail>
        get() = _movieDetail

    //좋아하는 기능 추가. mutablelivedata false 로 진행
    private val _movieFavorite = MutableLiveData(false)
    val moiveFavorite : LiveData<Boolean>
        get() = _movieFavorite

    fun fetchDetail(movie : Movie){
//코루틴의 구조적 관리.
        viewModelScope.launch {

           launch {
               queryFavoriteUseCase(movie).collectLatest {
                   it?.let {
                       _movieFavorite.value = true
                   }
               }
           }

            //오류처리가 같이들어갔다.null이 아닐시에 , 영화 상세 정보 출력
               //collectalatest -> movieusecase에서 flow처리시에 가장 최근에 데이터만 출력을 한다.
          detailMovieUseCase.invoke(movie).collectLatest { movieDetail ->
              movieDetail.data?.let {

                  _movieDetail.value = it
              }
          }
        }
    }

    fun updateMovie(movie : Movie){
        viewModelScope.launch {
            if(_movieFavorite.value == false){
                insertMovieUseCase.invoke(movie)
                _movieFavorite.value = true
            } else {
                deleteMovieUseCase(movie)
                _movieFavorite.value = false
            }
        }
    }

}


