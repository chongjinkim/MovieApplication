package com.soomgo.movieapp.data.data.local

import androidx.room.*
import com.soomgo.movieapp.domain.repository.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Query("SELECT * FROM Movie")
    fun getMovie() : Flow<List<Movie>>

    @Query("SELECT * FROM Movie WHERE ID = :id")
    fun getMovieById(id : Int) : Flow<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMovie(movie : Movie)

    @Delete
    suspend fun DeleteMovie(movie : Movie)

    @Update
    suspend fun UpdateMovie(movie : Movie)
}