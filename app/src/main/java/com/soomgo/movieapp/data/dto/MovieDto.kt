package com.soomgo.movieapp.data.dto

import android.os.Parcelable
import com.soomgo.movieapp.domain.model.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Int,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable


fun MovieDto.toMovie() = Movie(
    id = id,
    adult = adult,
    backdrop_path = backdrop_path,
    homepage = homepage,
    imdb_id = imdb_id,
    budget = budget,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    revenue = revenue,
    runtime = runtime,
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)








