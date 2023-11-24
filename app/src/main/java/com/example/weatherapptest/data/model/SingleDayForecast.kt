package com.example.weatherapptest.data.model

data class SingleDayForecast(
    val date: String,
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<DataList>,
    val message: Int
)
