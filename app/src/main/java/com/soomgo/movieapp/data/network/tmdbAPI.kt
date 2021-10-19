package com.soomgo.movieapp.data.network

import com.soomgo.movieapp.data.dto.DetailResponse
import com.soomgo.movieapp.data.dto.MovieResponse
import com.soomgo.movieapp.data.dto.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface tmdbAPI {

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