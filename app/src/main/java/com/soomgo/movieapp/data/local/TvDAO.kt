package com.soomgo.movieapp.data.local

import androidx.room.*
import com.soomgo.movieapp.domain.model.TV
import kotlinx.coroutines.flow.Flow

@Dao
interface TvDAO {

    @Query("SELECT * FROM TV")
    fun getTV() : Flow<List<TV>>

    @Query("SELECT * FROM TV WHERE ID = :id")
    suspend fun getTvById(id : Int) : Flow<TV>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InesrtTv(tv : TV)

    @Update
    suspend fun UpdateTv(tv : TV)

    @Delete
    suspend fun DeleteTv(tv: TV)
}