package com.example.weatherapptest.data.model

import com.example.weatherapptest.util.calcAverage

data class ForecastPreviewUIModel(
    val date: String,
    val city: String,
    val temp: String,
    val temp_max: String,
    val temp_min: String,
    val pressure: String,
    val humidity: String,
    val clouds: String,
    val windSpeed: String,
)
