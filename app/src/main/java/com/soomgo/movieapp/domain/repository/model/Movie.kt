package com.soomgo.movieapp.domain.repository.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soomgo.movieapp.data.data.dto.Genre
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class Movie(
    @PrimaryKey val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Int,
    val homepage: String,
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
) : Parcelable {

    companion object{

       val DiffUtil = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

        }
    }

}