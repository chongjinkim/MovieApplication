package com.soomgo.movieapp.data.local

import androidx.room.*
import com.soomgo.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    //dao 구현 -> 클래스는 movie로 구현 room에서 -> movie데이터 레이블에서 수정을 해야 하기 떄문에
    //moive를 넣는다.
    //flow -> 코루틴 구현시 순차적으로 movie클래스를 내보내고 예외 또는 완료가 되는 비동기 스트림
    //flow -> 코루틴 구현시 순차적으로 movie클래스를 내보내고 예외 또는 완료가 되는 비동기 스트림
    //delete, insert, update 라는 인터페이스의 상속을 받음
    //해당 쿼리는 모든 사용자를 조회하는 Room 에서의 Dao쿼리
    @Query("SELECT * FROM Movie")
    fun getMovies() : Flow<List<Movie>>
    //쿼리에 id값으로만 조회해서 다 조회가 됨
    @Query("SELECT * FROM Movie WHERE ID = :id")
    fun getMovieById(id : Int) : Flow<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMovie(movie : Movie)

    @Delete
    suspend fun DeleteMovie(movie : Movie)

    @Update
    suspend fun UpdateMovie(movie : Movie)
}