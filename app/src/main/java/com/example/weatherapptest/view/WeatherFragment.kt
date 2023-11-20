package com.example.weatherapptest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList
import com.example.weatherapptest.data.model.Weather
import com.example.weatherapptest.databinding.FragmentWeatherBinding
import com.example.weatherapptest.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    lateinit var binding: FragmentWeatherBinding
    private val viewModel: WeatherViewModel by viewModels()
    private val itemClickListener = object : ItemClickListener {
        override fun onDetailsClickListener(position: Int, data: DataList) {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val text = view.findViewById<TextView>(R.id.text)
        text.setOnClickListener {
            viewModel.print()
        }
        binding.btn.setOnClickListener {
            viewModel.fetchWeatherData()
        }
        viewModel.weatherData.observe(viewLifecycleOwner) { data ->
            val adapter = WeatherViewAdapter(data)
            binding.rvWeather.adapter = adapter
            binding.rvWeather.layoutManager = LinearLayoutManager(requireContext())

        }
        viewModel.uiState.onEach { state ->
            if (!state.loading) {
                progressBar.visibility = View.GONE
                binding.rvWeather.visibility = View.VISIBLE
            }
        }.launchIn(lifecycleScope)
    }
}