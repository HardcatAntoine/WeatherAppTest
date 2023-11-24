package com.example.weatherapptest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapptest.data.repo.WeatherRepository
import com.example.weatherapptest.util.UNITS
import com.example.weatherapptest.util.toForecastPreviewUIModel
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

    fun fetchWeatherData(lat: Double, lon: Double) {
        viewModelScope.launch {
            val localData = repository.getSavedData()
            if (localData == null) {
                val response = repository.getWeather(lat.toString(), lon.toString(), UNITS)
                repository.saveResponseData(response)
                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        response.toSingleDayForecast().toForecastPreviewUIModel()
                    )
                }
            } else {
                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        forecastDay = localData.toSingleDayForecast().toForecastPreviewUIModel()
                    )
                }
            }

        }

    }
}


