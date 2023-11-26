package com.example.weatherapptest.view

import com.example.weatherapptest.data.model.SingleDayForecast

data class DetailFragmentUIState(
    val forecastDay: List<SingleDayForecast> = emptyList()
)
