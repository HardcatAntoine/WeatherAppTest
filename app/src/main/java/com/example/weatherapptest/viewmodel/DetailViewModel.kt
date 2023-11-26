package com.example.weatherapptest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherapptest.data.repo.WeatherRepository
import com.example.weatherapptest.view.DetailFragmentUIState
import com.example.weatherapptest.view.DetailsFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _detailsUISState = MutableStateFlow(DetailFragmentUIState())
    val detailUIState = _detailsUISState.asStateFlow()

//    fun fetchDetailWeatherData(args: DetailsFragmentArgs) {
//        val localData = repository.getSavedData()
//        _detailsUISState.update { state ->
//            state.copy(forecastDay = localData!!.toDetailSingleDayForecast(args.Date))
//        }
//    }
}