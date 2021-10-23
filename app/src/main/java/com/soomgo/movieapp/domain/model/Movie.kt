package com.soomgo.movieapp.domain.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Movie(
    @PrimaryKey val id: Int,
    val adult: Boolean,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int

) : Parcelable {


//DiifUtil -> RecyclerView 구현시에 , 두 객체가 같은 항목인지, 두 항목의 데이터가 같은지 여부를 판단하여, 갱신하여 준다.
//DiffUtil -> RecyclerView 구현시에, 두 객체가 같은 항목인지 , 두 항목의 데이터가 같은지 여부 판단하여 갱신하여 준다.
    companion object{

       val DiffUtil = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

        }
    }

}