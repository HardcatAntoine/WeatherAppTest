package com.example.weatherapptest.data.repo

import com.example.weatherapptest.data.model.WeatherData
import com.example.weatherapptest.data.remote.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather(): WeatherData {
        return apiService.getWeatherData()
    }
}