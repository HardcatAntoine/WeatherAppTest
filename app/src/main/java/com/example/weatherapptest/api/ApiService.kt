package com.example.weatherapptest.api

import com.example.weatherapptest.data.WeatherData
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getWeatherData(): WeatherData
}