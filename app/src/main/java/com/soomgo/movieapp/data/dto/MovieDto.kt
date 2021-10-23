package com.soomgo.movieapp.data.dto

import android.os.Parcelable
import com.soomgo.movieapp.domain.model.Movie
import kotlinx.android.parcel.Parcelize


//데이터를 보내기 위해서 model 에서 @Parcelize annotation을 넣어준다.
//DTO -> 데이터를 오브젝트로 변환하는 객체 이를 활용하여 DB혹은 서버에서 데이터를 받아올 때
//데이터를 받고 데이터 접근, 읽기만 할 수 있음
//DB에서 데이터를 얻어서 순수한 데이터 객체 getter/setter 메서드만을 갖거나 request와 response용으로 활용이 가능
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
    val vote_count: Int,
    val is_favorite : Boolean
) : Parcelable

//movieDto mapping 작업 진행
//toMovie로 mapper를 사용을 한 이유 -> domain에서의 model과 dto단에서의 response로 값을 주는
//모든 값을 movie클래스에서는 사용하지 않기 때문에, 실제 사용할 반응만 mapper작업을 진행
fun MovieDto.toMovie() = Movie(
    id = id,
    adult = adult,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count,

)








