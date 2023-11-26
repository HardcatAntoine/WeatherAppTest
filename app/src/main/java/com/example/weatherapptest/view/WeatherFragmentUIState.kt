package com.example.weatherapptest.view

import com.example.weatherapptest.data.model.ForecastPreviewUIModel

data class WeatherFragmentUIState(
    val loading: Boolean = true,
    val forecastDay: List<ForecastPreviewUIModel> = emptyList(),
    val error: Boolean = false
)