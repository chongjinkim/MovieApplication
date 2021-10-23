package com.soomgo.movieapp.di

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.soomgo.movieapp.data.local.MovieDatabase
import com.soomgo.movieapp.data.network.Client
import com.soomgo.movieapp.data.repository.MovieRepositoryImpl
import com.soomgo.movieapp.domain.repository.MovieRepository
import com.soomgo.movieapp.domain.usecase.*
import com.soomgo.movieapp.presentation.detail.DetailViewModel
import com.soomgo.movieapp.presentation.movie.MovieViewModel
import com.soomgo.movieapp.presentation.my.MyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sign


//koin으로 module 생성
val utilModule = module {
    single { GsonBuilder().setPrettyPrinting().create() }

}
val localDataModule = module {
    fun provideDataBase(application: Application) = Room
        .databaseBuilder(application, MovieDatabase::class.java, "movies")
        .fallbackToDestructiveMigration()
        .build()

    fun provideMovieDao(database: MovieDatabase) = database.movieDao

    single { provideDataBase(get()) }
    single { provideMovieDao(get()) }

}



val remoteDataModule = module {
    single { Client(get()) }
    single<MovieRepository> {MovieRepositoryImpl(get(), get())}
}

val viewModelModule = module {
    viewModel { MovieViewModel(get(), get(), get()) }
    viewModel { MyViewModel(get()) }
    viewModel { DetailViewModel(get(), get(), get(), get()) }
}

val useCaseModule = module {
    single { DeleteMovieUseCase(get()) }
    single { DetailMovieUseCase(get()) }
    single { InsertMovieUseCase(get()) }
    single { PopularMovieUseCase(get())}
    single { QueryFavoritesUseCase(get()) }
    single { QueryFavoriteUseCase(get()) }
    single { TopRatedMovieUseCase(get()) }
    single { UpcomingMovieUseCase(get()) }
}

val applicationModule = listOf(
    utilModule,
    localDataModule,
    remoteDataModule,
    viewModelModule,
    useCaseModule
)
