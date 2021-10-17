package com.soomgo.movieapp

import android.app.Application
import com.soomgo.movieapp.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(applicationModule)
        }
    }
}
