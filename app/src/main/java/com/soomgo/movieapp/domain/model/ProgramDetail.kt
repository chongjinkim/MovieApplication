package com.soomgo.movieapp.domain.model

import com.soomgo.movieapp.data.dto.ProgramGenre
import com.soomgo.movieapp.data.dto.ProgramProductionCompany
import com.soomgo.movieapp.data.dto.ProgramProductionCountry
import com.soomgo.movieapp.data.dto.ProgramSpokenLanguage

data class ProgramDetail(
    val backdrop_path: String,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<ProgramGenre>,
    val homepage: String,
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
    val production_companies: List<ProgramProductionCompany> = emptyList(),
    val production_countries: List<ProgramProductionCountry> = emptyList(),
    val spoken_languages: List<ProgramSpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)