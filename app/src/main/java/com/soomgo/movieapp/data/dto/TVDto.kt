package com.soomgo.movieapp.data.dto

import android.os.Parcelable
import com.soomgo.movieapp.domain.model.TV
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TVDto(
    val genres: List<TVGenre>,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val name: String,
    val next_episode_to_air: Any,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<TVProductionCompany>,
    val production_countries: List<TVProductionCountry>,
    val spoken_languages: List<TVSpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable

fun TVDto.toTV() = TV(
    id = id,
    name = name,
    original_language = original_language,
    original_name = original_name,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    vote_average = vote_average,
    vote_count = vote_count
)