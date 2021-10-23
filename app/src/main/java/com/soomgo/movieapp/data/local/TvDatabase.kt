package com.soomgo.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.soomgo.movieapp.domain.model.TV


@Database(
    entities = [TV::class],
    version = 1
)


abstract class TvDatabase : RoomDatabase(){

    abstract val tvDao : TvDAO

    companion object{

        const val DATA_BASE_NAME = "tv_db"
    }
}