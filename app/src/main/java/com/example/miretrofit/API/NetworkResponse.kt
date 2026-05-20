package com.example.miretrofit.API




    sealed class NetworkResponse<out T>{
        data class Success<out T>(val data:T): NetworkResponse<T>()
        data class Error(val mensaje: String): NetworkResponse<Nothing>()
        object loading: NetworkResponse<Nothing>()

        //tra success por si todo va bien
    }

