package com.example.miretrofit.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InstanciaRetrofit {
    private val URL_BASE = "https://api.openweathermap.org"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //todo falta crear la instancia
    val ClimaApi =getInstance().create(ClimaApI::class.java)
}
