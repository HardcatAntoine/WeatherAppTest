package com.example.weatherapptest.data.remote

import com.example.weatherapptest.data.model.WeatherData
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getWeatherData(): WeatherData
}