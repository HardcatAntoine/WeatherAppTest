package com.example.weatherapptest.view

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapptest.databinding.FragmentWeatherBinding
import com.example.weatherapptest.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.sql.Date
import java.sql.Timestamp

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var locationService: LocationService
    private val viewModel: WeatherViewModel by viewModels()
    private val adapter = WeatherViewAdapter()
    private val itemClickListener = object : ItemClickListener {
        override fun onDetailsClickListener(position: Int) {
            val action = WeatherFragmentDirections.actionWeatherFragmentToDetailsFragment(position)
            findNavController().navigate(action)
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
        val timeStamp = Timestamp(System.currentTimeMillis())
        val date = Date(timeStamp.time).toString()
        viewModel.saveDate(date)
        initAdapter()
        observer()
        if (isInternetAvaliable()) {
            locationService = LocationService(requireContext()) { location ->
                viewModel.fetchWeatherData(location.latitude, location.longitude, date)
            }
        } else {
            viewModel.fetchWeatherData(null, null, date)
        }
    }

    private fun initAdapter() {
        binding.rvWeather.adapter = adapter
        binding.rvWeather.layoutManager = LinearLayoutManager(requireContext())
        adapter.setOnItemClickListener(itemClickListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        locationService.clearListener()
    }

    private fun isInternetAvaliable(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork
        val activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities)
        return activeNetwork != null
    }

    private fun observer() {
        viewModel.uiState.onEach { state ->
            if (!state.loading) {
                binding.progressBar.visibility = View.GONE
                binding.rvWeather.visibility = View.VISIBLE
                adapter.setList(state.forecastDay)
            }
        }.launchIn(lifecycleScope)
    }

}