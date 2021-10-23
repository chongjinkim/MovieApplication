package com.soomgo.movieapp.domain.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TV(
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable{

    companion object{

        val DiffUtil = object : DiffUtil.ItemCallback<TV>(){
            override fun areItemsTheSame(oldItem: TV, newItem: TV) = oldItem == newItem

            override fun areContentsTheSame(oldItem: TV, newItem: TV) = oldItem == newItem
        }

    }
}