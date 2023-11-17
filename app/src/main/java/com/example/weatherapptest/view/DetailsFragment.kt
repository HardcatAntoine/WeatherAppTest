package com.example.weatherapptest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapptest.R
import com.example.weatherapptest.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

}