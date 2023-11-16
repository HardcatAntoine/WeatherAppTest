package com.example.weatherapptest.data.repo

import com.example.weatherapptest.data.model.WeatherData
import com.example.weatherapptest.data.remote.ApiProvider

class WeatherRepository(private val apiProvider: ApiProvider) {
    suspend fun getWeather(): WeatherData {
        return apiProvider.apiService.getWeatherData()
    }
}