package com.soomgo.movieapp.domain.model

import com.soomgo.movieapp.data.dto.Genre
import com.soomgo.movieapp.data.dto.ProductionCompany
import com.soomgo.movieapp.data.dto.ProductionCountry
import com.soomgo.movieapp.data.dto.SpokenLanguage

data class TVDetail(
    val genres: List<Genre>,
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
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)