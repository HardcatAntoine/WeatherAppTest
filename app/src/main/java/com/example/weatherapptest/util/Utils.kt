package com.example.weatherapptest.util

import com.example.weatherapptest.data.model.ForecastPreviewUIModel
import com.example.weatherapptest.data.model.SingleDayForecast
import java.math.BigDecimal
import java.math.RoundingMode
import java.sql.Date
import java.sql.Timestamp
import kotlin.math.roundToInt
import kotlin.math.roundToLong

fun convertToDate(timeStamp: Int): Date {
    return Date(Timestamp(timeStamp.toLong() * 1000).time)
}

fun List<Number>.calcAverage(): Double {
    var sum = 0.0
    this.forEach { sum += it.toDouble() }
    val random = sum / this.size
    return random.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
}

fun List<SingleDayForecast>.toForecastPreviewUIModel(): List<ForecastPreviewUIModel> {
    return this.map { singleDayForecast ->
        ForecastPreviewUIModel(
            date = singleDayForecast.date,
            city = singleDayForecast.city.name,
            temp = singleDayForecast.list.first().main.temp.toString(),
            temp_max = singleDayForecast.list.maxOf { it.main.temp_max }.toString(),
            temp_min = singleDayForecast.list.minOf { it.main.temp_min }.toString(),
            pressure = singleDayForecast.list.map { it.main.pressure }.calcAverage().toString(),
            humidity = singleDayForecast.list.map { it.main.humidity }.calcAverage().toString(),
            clouds = singleDayForecast.list.map { it.clouds.all }.calcAverage().toString(),
            windSpeed = singleDayForecast.list.map { it.wind.speed }.calcAverage().toString()
        )
    }
}