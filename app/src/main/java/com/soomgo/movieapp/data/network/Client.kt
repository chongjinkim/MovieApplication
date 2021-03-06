package com.soomgo.movieapp.data.network

import com.google.gson.Gson
import com.soomgo.movieapp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//클라이언트 객체 생성 ->Gson
//okhttpclient, retrofit사용,AuthInterceptor -> bear token에 넣어서 사용,
//세션 끊김 방지 역할 진행
//client log출력시 buildconfig 넣을때 절대로 koin으로 넣지 말것.
//koin으로 넣을 시에-> log가 출력이 안된다.

class Client(private val gSon : Gson)  {

    val client : Retrofit = createClient()
    val TmdbAPI : tmdbAPI = createClient(USER_BASE_URL).create(tmdbAPI::class.java)

//Http통신을 로그로 기록할 때 사용이 되어지는 코드이다.
    private val httpLogLevel
        get() = if(BuildConfig.DEBUG) HttpCustomLoggingInterceptor.Level.BODY else HttpCustomLoggingInterceptor.Level.NONE

    fun createClient(host : String = USER_BASE_URL) : Retrofit{

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpCustomLoggingInterceptor().apply {level = httpLogLevel})
            .addInterceptor(AuthInterceptor())
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .client(okHttpClient)
            .baseUrl(host)
            .build()
    }

    companion object{
        private const val CONNECT_TIMEOUT = 10L
        private const val WRITE_TIMEOUT = 10L
        private const val READ_TIMEOUT = 10L
        private const val USER_BASE_URL = "https://api.themoviedb.org/"
    }
}