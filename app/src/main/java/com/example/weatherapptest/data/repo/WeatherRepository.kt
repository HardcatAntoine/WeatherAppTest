package com.example.weatherapptest.data.repo

import com.example.weatherapptest.data.local.Preference
import com.example.weatherapptest.data.model.WeatherData
import com.example.weatherapptest.data.remote.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: ApiService,
    private val preference: Preference
) {
    suspend fun getWeather(lat: String, lon: String, units: String): WeatherData {
        return apiService.getWeatherData(lat, lon, units)
    }

    fun getLatitude(): String? {
        return preference.getSavedLatitude()
    }

    fun getLongitude(): String? {
        return preference.getSavedLongitude()
    }
}