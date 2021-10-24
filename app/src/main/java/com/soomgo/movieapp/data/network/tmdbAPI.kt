package com.soomgo.movieapp.data.network

import com.soomgo.movieapp.data.dto.*
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
    suspend fun getDetailMovie(@Path("id") id : String) : DetailResponse

    @GET("/3/tv/popular")
    suspend fun getPopularTv() : TVResponse

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTv() : TVResponse

    @GET("/3/tv/on_the_air")
    suspend fun getOnTheAirTv() : TVOnTheAirResponse

    @GET("/3/tv/{id}")
    suspend fun getDetailTv(@Path("id") id : String) : TVDetailResponse
}