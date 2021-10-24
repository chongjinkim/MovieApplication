package com.soomgo.movieapp.data.network

import com.soomgo.movieapp.data.dto.DetailResponse
import com.soomgo.movieapp.data.dto.MovieResponse
import com.soomgo.movieapp.data.dto.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface tmdbAPI {

//api접속할 주소 가져옴,
//api 정보 받아 올 떄 키와 토큰값이 반드시 있어야 한다.
//api정모 가져올때 키, 토큰 둘다 필요 !
    @GET("/3/movie/popular")
    suspend fun getPopularMovie() : MovieResponse

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovie() : MovieResponse

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovie() : UpComingResponse

    @GET("/3/movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id : String
    ) : DetailResponse

}