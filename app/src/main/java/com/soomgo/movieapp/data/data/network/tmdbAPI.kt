package com.soomgo.movieapp.data.data.network

import com.soomgo.movieapp.data.data.dto.DetailResponse
import com.soomgo.movieapp.data.data.dto.MovieResponse
import com.soomgo.movieapp.data.data.dto.UpComingResponse
import retrofit2.http.GET

interface tmdbAPI {

    @GET("/3/moive/popular")
    suspend fun getPopularMovie() : MovieResponse

    @GET("/3/moive/top_rated")
    suspend fun getTopRatedMovie() : MovieResponse


    @GET("/3/moive/upcoming")
    suspend fun getUpcomingMovie() : UpComingResponse

    @GET("/3/movie/{movie_id}")
    suspend fun getDetailMovie() : DetailResponse

}