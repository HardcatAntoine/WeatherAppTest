package com.example.weatherapptest.view

import com.example.weatherapptest.data.model.ForecastPreviewUIModel

interface ItemClickListener {
    fun onDetailsClickListener(position: Int, data: ForecastPreviewUIModel)
}