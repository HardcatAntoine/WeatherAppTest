package com.example.weatherapptest.data.repo

import com.example.weatherapptest.data.local.Preference
import com.example.weatherapptest.data.model.SingleDayForecast
import com.example.weatherapptest.data.model.WeatherData
import com.example.weatherapptest.data.remote.ApiService
import java.text.FieldPosition
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: ApiService,
    private val preference: Preference
) {
    suspend fun getWeather(lat: String, lon: String, units: String): List<SingleDayForecast>? {
        return if (getSingleDayForecasts() == null) {
            saveSingleDayForecasts(apiService.getWeatherData(lat, lon, units).toSingleDayForecast())
            getSingleDayForecasts()
        } else {
            getSingleDayForecasts()
        }
    }

    fun getSingleDayForecast(index: Int): SingleDayForecast? {
       return getSingleDayForecasts()?.get(index)
    }

    private fun saveSingleDayForecasts(data: List<SingleDayForecast>) {
        preference.saveWeatherData(data)
    }

    private fun getSingleDayForecasts(): List<SingleDayForecast>? {
        return preference.getWeatherData()
    }


}