package com.soomgo.movieapp.data.local

import androidx.room.*
import com.soomgo.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    //flow -> 순차적으로 값을 보내고 정상적으로 예외 및 완료가 되는 비동기 스트림
    @Query("SELECT * FROM Movie")
    fun getMovies() : Flow<List<Movie>>

    @Query("SELECT * FROM Movie WHERE ID = :id")
    fun getMovieById(id : Int) : Flow<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMovie(movie : Movie)

    @Delete
    suspend fun DeleteMovie(movie : Movie)

    @Update
    suspend fun UpdateMovie(movie : Movie)
}