package com.soomgo.movieapp.data.dto

import com.soomgo.movieapp.domain.model.MovieDetail


//가져올 데이터를 클래스로 정리한 다음, 각각의 Response로 지정을 한다.
//가져올 데이터를 클래스로 정리를 한 다음에 각각의 가져올 데이터만 정리를 한다.
//model 반응을 data class로 정리를 한 다음, ui딴에 필요한 반응만 model로 정리를 한다.
data class MovieResponse(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)

data class UpComingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)

data class DetailResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val is_favorite : Boolean
)

//데이터를 보내기 위해서 model 에서 @Parcelize annotation을 넣어준다.
//DTO -> 데이터를 오브젝트로 변환하는 객체 이를 활용하여 DB혹은 서버에서 데이터를 받아올 때
//데이터를 받고 데이터 접근, 읽기만 할 수 있음
//DB에서 데이터를 얻어서 순수한 데이터 객체 getter/setter 메서드만을 갖거나 request와 response용으로 활용이 가능
fun DetailResponse.toMovieDetail() : MovieDetail = MovieDetail(
    adult = adult,
    backdrop_path = backdrop_path,
    belongs_to_collection = belongs_to_collection,
    budget = budget,
    genres = genres,
    homepage = homepage,
    id = id,
    imdb_id = imdb_id,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    production_companies = production_companies,
    production_countries = production_countries,
    release_date = release_date,
    revenue = revenue,
    runtime = runtime,
    spoken_languages = spoken_languages,
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count,

)






