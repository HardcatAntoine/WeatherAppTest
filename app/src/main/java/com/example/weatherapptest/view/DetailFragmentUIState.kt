package com.example.weatherapptest.view

import com.example.weatherapptest.data.model.SingleDayForecast

data class DetailFragmentUIState(
    val error: Boolean = false,
    val forecastDay: SingleDayForecast? = null
)
