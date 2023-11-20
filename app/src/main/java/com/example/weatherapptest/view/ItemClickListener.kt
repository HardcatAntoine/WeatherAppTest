package com.example.weatherapptest.view

import com.example.weatherapptest.data.model.DataList

interface ItemClickListener {
    fun onDetailsClickListener(position: Int, data: DataList)
}