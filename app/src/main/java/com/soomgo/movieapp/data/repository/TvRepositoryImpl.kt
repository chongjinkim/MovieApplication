package com.soomgo.movieapp.data.repository

import com.soomgo.movieapp.data.dto.TVDetailResponse
import com.soomgo.movieapp.data.dto.TVOnTheAirResponse
import com.soomgo.movieapp.data.dto.TVResponse
import com.soomgo.movieapp.data.local.TvDAO
import com.soomgo.movieapp.data.network.Client
import com.soomgo.movieapp.domain.model.TV
import com.soomgo.movieapp.domain.repository.TVRepository
import kotlinx.coroutines.flow.Flow

class TvRepositoryImpl(val client: Client, val dao : TvDAO) : TVRepository {
    override suspend fun fetchPopulartTv() = client.TmdbAPI.getPopularTv()

    override suspend fun fetchTopRatedTv() = client.TmdbAPI.getTopRatedTv()

    override suspend fun fetchOnTheAirTv() = client.TmdbAPI.getOnTheAirTv()

    override suspend fun fetchDetailTv(id: String) = client.TmdbAPI.getDetailTv(id)

    override fun queryTVs(): Flow<List<TV>>  = dao.getTV()

    override suspend fun queryTv(tv: TV): Flow<TV> = dao.getTvById(tv.id)

    override suspend fun insertTv(tv: TV)  = dao.InesrtTv(tv)

    override suspend fun deleteTv(tv: TV) = dao.DeleteTv(tv)
}