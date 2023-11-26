package com.example.weatherapptest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapptest.databinding.FragmentDetailsBinding
import com.example.weatherapptest.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailViewModel by viewModels()
    private val adapter = DetailsAdapter()
    private val args: DetailsFragmentArgs by lazy {
        DetailsFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
//        viewModel.fetchDetailWeatherData(args)
//        viewModel.detailUIState.onEach { state ->
//            adapter.setList(state.forecastDay)
//        }
    }


    private fun initAdapter() {
        binding.rvDetails.adapter = adapter
        binding.rvDetails.layoutManager = LinearLayoutManager(requireContext())
    }

}