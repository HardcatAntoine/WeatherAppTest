package com.example.weatherapptest.data.remote

import com.example.weatherapptest.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast")
    suspend fun getWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String,
    ): WeatherData
}