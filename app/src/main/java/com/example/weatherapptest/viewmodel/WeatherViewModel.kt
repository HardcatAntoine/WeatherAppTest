package com.example.weatherapptest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.weatherapptest.data.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    fun print(){
        Log.d("ViewModelTest", "TEST")
    }
}