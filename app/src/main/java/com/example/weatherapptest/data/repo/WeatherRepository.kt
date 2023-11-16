package com.example.weatherapptest.data.repo

import com.example.weatherapptest.FAKE_GEO_DATA
import com.example.weatherapptest.data.model.WeatherData
import com.example.weatherapptest.data.remote.ApiService
import com.example.weatherapptest.util.API_KEY
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather(lat: Double, lon: Double, apiKey: String): WeatherData {
        return apiService.getWeatherData(lat, lon, apiKey)
    }
}