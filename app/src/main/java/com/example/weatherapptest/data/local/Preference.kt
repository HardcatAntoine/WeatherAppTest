package com.example.weatherapptest.data.local

import android.content.Context
import androidx.core.content.edit
import com.example.weatherapptest.data.model.WeatherData
import com.google.gson.Gson
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preference @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) {
    private val sharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveLatitude(latitude: String) {
        sharedPreferences.edit { putString(LAT_KEY, latitude) }
    }

    fun saveLongitude(longitude: String) {
        sharedPreferences.edit { putString(LON_KEY, longitude) }
    }

    fun getSavedLatitude(): String? {
        return sharedPreferences.getString(LAT_KEY, null)
    }

    fun getSavedLongitude(): String? {
        return sharedPreferences.getString(LON_KEY, null)
    }

    fun saveWeatherData(data: WeatherData) {
        sharedPreferences
            .edit()
            .putString(WEATHER_DATA_KEY, gson.toJson(data))
            .apply()
    }

    fun getWeatherData(): WeatherData? {
        return gson.fromJson(
            sharedPreferences.getString(WEATHER_DATA_KEY, null),
            WeatherData::class.java
        )
    }

    fun clearWeatherData() {
        sharedPreferences
            .edit()
            .remove(WEATHER_DATA_KEY)
            .apply()
    }

    companion object {
        const val LAT_KEY = "lat"
        const val LON_KEY = "lon"
        const val WEATHER_DATA_KEY = "weatherData"
    }
}