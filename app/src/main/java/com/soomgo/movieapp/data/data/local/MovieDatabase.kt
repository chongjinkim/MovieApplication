package com.soomgo.movieapp.data.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.soomgo.movieapp.domain.repository.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)

abstract class MovieDatabase : RoomDatabase() {

    abstract val movieDao : MovieDAO

    companion object{

        const val DATA_BASE_NAME = "movie_db"
    }

}