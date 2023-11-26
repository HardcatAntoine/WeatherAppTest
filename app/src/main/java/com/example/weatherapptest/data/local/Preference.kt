package com.example.weatherapptest.data.local

import android.content.Context
import com.example.weatherapptest.data.model.SingleDayForecast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.internal.isSensitiveHeader
import javax.inject.Inject

class Preference @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) {
    private val sharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveWeatherData(data: List<SingleDayForecast>) {
        sharedPreferences
            .edit()
            .putString(WEATHER_DATA_KEY, gson.toJson(data))
            .apply()
    }

    fun getWeatherData(): List<SingleDayForecast>? {
        return gson.fromJson(
            sharedPreferences.getString(WEATHER_DATA_KEY, null),
            object : TypeToken<List<SingleDayForecast>>() {}.type
        )
    }

    fun saveCurrentDate(date: String) {
        sharedPreferences.edit().putString("CurrentDate", date)
    }

    fun getSavedDate(): String? {
        return sharedPreferences.getString("CurrentDate", null)
    }


    fun clearWeatherData() {
        sharedPreferences
            .edit()
            .remove(WEATHER_DATA_KEY)
            .remove(CURRENT_DATE)
            .apply()
    }

    companion object {
        const val CURRENT_DATE = "CurrentDate"
        const val WEATHER_DATA_KEY = "weatherData"
    }
}