package com.example.weatherapptest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapptest.FakeGeoData
import com.example.weatherapptest.data.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    fun print() {
        Log.d("ViewModelTest", "TEST")
    }

    fun fetchWeatherData(fakeGeoData: FakeGeoData, apiKey: String) {
        viewModelScope.launch {
            repository.getWeather(fakeGeoData.lat, fakeGeoData.lon, apiKey)
        }
    }
}