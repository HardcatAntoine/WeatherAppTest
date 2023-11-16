package com.example.weatherapptest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.weatherapptest.FAKE_GEO_DATA
import com.example.weatherapptest.R
import com.example.weatherapptest.util.API_KEY
import com.example.weatherapptest.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val text = view.findViewById<TextView>(R.id.text)
        text.setOnClickListener {
            viewModel.fetchWeatherData(FAKE_GEO_DATA, API_KEY)
        }
        viewModel.uiState.onEach { state ->
            if (!state.loading) {
                progressBar.visibility = View.GONE
                text.visibility = View.VISIBLE
            }
        }.launchIn(lifecycleScope)
    }
}