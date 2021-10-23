package com.soomgo.movieapp.domain.repository

import com.soomgo.movieapp.data.dto.DetailResponse
import com.soomgo.movieapp.data.dto.MovieResponse
import com.soomgo.movieapp.data.dto.UpComingResponse
import com.soomgo.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {


    //repository설정, room db와 model을 처리하기 위한 원천
    //suspend -> suspend function 일시 중단이 가능한 함수, suspend function 코루틴 안에서만 호출이 가능하다.

    suspend fun fetchPopularMovie() : MovieResponse
    suspend fun fetchTopRatedMovie() : MovieResponse
    suspend fun fetchUpcomingMovie() : UpComingResponse
    suspend fun fetchDetailMovie(id : String) : DetailResponse

    fun queryMovies() : Flow<List<Movie>>//모든 데이터를 다 조회를 하기 때문에 Flow,List,Movie모델로 넣는다.
    suspend fun queryMovie(movie : Movie) : Flow<Movie>
    suspend fun insertMovie(movie : Movie)
    suspend fun deleteMovie(movie : Movie)

}