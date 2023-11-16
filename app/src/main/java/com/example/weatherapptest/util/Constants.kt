package com.example.weatherapptest

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

data class FakeGeoData(
    val lat: Double = 34.0901,
    val lon: Double = -118.4065
)

val FAKE_GEO_DATA = FakeGeoData()