package com.example.esiea3a.presentation

import com.example.esiea3a.presentation.api.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singleton {
    companion object{
        fun getWeatherApi(){

        }

val WeatherApi: WeatherApi = Retrofit.Builder()
    .baseUrl( "https://pro-api.coinmarketcap.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(com.example.esiea3a.presentation.api.WeatherApi::class.java)

    }
}