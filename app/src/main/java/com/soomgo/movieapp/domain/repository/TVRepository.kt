package com.soomgo.movieapp.domain.repository

import com.soomgo.movieapp.data.dto.TVDetailResponse
import com.soomgo.movieapp.data.dto.TVOnTheAirResponse
import com.soomgo.movieapp.data.dto.TVResponse
import com.soomgo.movieapp.domain.model.TV
import kotlinx.coroutines.flow.Flow

interface TVRepository{

    suspend fun fetchPopulartTv() : TVResponse
    suspend fun fetchTopRatedTv() : TVResponse
    suspend fun fetchOnTheAirTv() : TVOnTheAirResponse
    suspend fun fetchDetailTv(id : String) : TVDetailResponse

    fun queryTVs() : Flow<List<TV>>
    suspend fun queryTv(tv : TV) : Flow<TV>
    suspend fun insertTv(tv : TV)
    suspend fun deleteTv(tv : TV)

}