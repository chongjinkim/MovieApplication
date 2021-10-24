package com.soomgo.movieapp.data.dto

import com.soomgo.movieapp.domain.model.TVDetail

data class TVResponse(
    val page: Int,
    val results: List<TVDto>,
    val total_pages: Int,
    val total_results: Int
)

data class TVOnTheAirResponse(
    val page: Int,
    val results: List<TVDto>,
    val total_pages: Int,
    val total_results: Int
)

data class TVDetailResponse(
    val genres: List<Genre>,
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
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)

fun TVDetailResponse.toTVDetail() = TVDetail(

    genres = genres,
    id = id,
    in_production = in_production,
    languages = languages,
    last_air_date = last_air_date,
    name = name,
    next_episode_to_air = next_episode_to_air,
    number_of_episodes = number_of_episodes,
    number_of_seasons = number_of_seasons,
    original_language = original_language,
    original_name = original_name,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    production_companies = production_companies,
    production_countries = production_countries,
    spoken_languages = spoken_languages,
    status = status,
    tagline = tagline,
    type = type,
    vote_average = vote_average,
    vote_count = vote_count


)



