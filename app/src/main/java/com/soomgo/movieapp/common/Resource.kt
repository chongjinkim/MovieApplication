package com.soomgo.movieapp.common


//api통신을 시도 했을 때  성공, 에러, 실패 시 어떻게 처리할 지 하는 클래스
sealed class Resource<T>(val data : T? = null, val message: String? = null) {

    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message : String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}