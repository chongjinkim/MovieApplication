package com.soomgo.movieapp.domain.model

import com.soomgo.movieapp.data.dto.TVGenre
import com.soomgo.movieapp.data.dto.TVProductionCompany
import com.soomgo.movieapp.data.dto.TVProductionCountry
import com.soomgo.movieapp.data.dto.TVSpokenLanguage

data class TVDetail(
    val genres: List<TVGenre>,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val name: String,
    val next_episode_to_air: Any,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
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
)