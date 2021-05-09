package com.example.esiea3a.presentation.api

import com.example.esiea3a.presentation.list.City
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



interface WeatherApi {


    @GET( "/v1/cryptocurrency/listings/latest")
    fun getWeatherList(@Query("CMC_PRO_API_KEY") key: String= "99ec2a96-ed01-4d23-8c51-d1a9a7ade8a7"): Call<WeatherResponse>


    @GET( "/v1/cryptocurrency/listings/latest")
    fun getCovidDetail(@Query("CMC_PRO_API_KEY") key: String= "99ec2a96-ed01-4d23-8c51-d1a9a7ade8a7"): Call<CovidDetailResponse>

}