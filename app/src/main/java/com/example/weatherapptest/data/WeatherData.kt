package com.example.weatherapptest.data

data class WeatherData(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<DataList>,
    val message: Int
)