package com.example.weatherapptest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapptest.data.repo.WeatherRepository
import com.example.weatherapptest.view.WeatherFragmentUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(WeatherFragmentUIState())
    val uiState = _uiState.asStateFlow()
    fun print() {
        val lat = repository.getLatitude()
        Log.d("ViewModelTest", "lat")
    }

    fun fetchWeatherData(lat: Double, lon: Double) {
//        val fetchingJob = viewModelScope.async {
//            repository.getWeather(fakeGeoData.lat, fakeGeoData.lon, apiKey)
//        }
        viewModelScope.launch {
            repository.getWeather(lat, lon)
            _uiState.update { state ->
                state.copy(loading = false)
            }
        }
    }


}