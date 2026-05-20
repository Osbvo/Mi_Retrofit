package com.example.miretrofit.API

import com.example.miretrofit.modelos.ClimaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ClimaApI {
    @GET ("/dta/2.5/wheather")
    suspend fun getClima(
        @Query ("appid")apikey : String,
        @Query("q")ciudad : String,
        @Query("units") unidades: String
    ): Response<ClimaModel>
}