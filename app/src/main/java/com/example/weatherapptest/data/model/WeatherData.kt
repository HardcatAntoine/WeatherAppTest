package com.example.weatherapptest.data.model

import com.example.weatherapptest.util.convertToDate

data class WeatherData(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<DataList>,
    val message: Int
) {
    fun toSingleDayForecast(): List<SingleDayForecast> {
        val singleDayForecasts = mutableListOf<SingleDayForecast>()
        var currentDate = ""

        this.list.map { forecastDataDto ->
            val date = convertToDate(forecastDataDto.dt).toString()
            val singleDateList = this.list.filter { dto -> dto.dt_txt.contains(date) }
            if (currentDate != date) {
                currentDate = date
                singleDayForecasts.add(
                    SingleDayForecast(
                        date = date,
                        city = this.city,
                        cnt = this.cnt,
                        cod = this.cod,
                        list = singleDateList,
                        message = this.message
                    )
                )
            }
        }
        return singleDayForecasts
    }
}