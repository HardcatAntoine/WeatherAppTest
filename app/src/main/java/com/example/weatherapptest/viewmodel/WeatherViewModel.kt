package com.example.weatherapptest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapptest.data.model.DataList
import com.example.weatherapptest.data.repo.WeatherRepository
import com.example.weatherapptest.util.UNITS
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
    private val _weatherData = MutableLiveData<List<DataList>>()
    val weatherData: LiveData<List<DataList>>
        get() = _weatherData

    fun fetchWeatherData() {
        viewModelScope.launch {
            val lat = repository.getLatitude()
            val lon = repository.getLongitude()
            _weatherData.value = repository.getWeather(lat!!, lon!!, UNITS).list
            _uiState.update { state ->
                state.copy(loading = false)
            }
        }
    }


}