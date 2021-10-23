package com.soomgo.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.soomgo.movieapp.domain.model.Movie


//데이터 테이블 완성, Room 설정 완료
@Database(
    entities = [Movie::class],
    version = 2
)

abstract class MovieDatabase : RoomDatabase() {

    abstract val movieDao : MovieDAO

    companion object{

        const val DATA_BASE_NAME = "movie_db"
    }

}