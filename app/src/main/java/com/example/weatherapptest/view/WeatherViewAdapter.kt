package com.example.weatherapptest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList
import com.example.weatherapptest.data.model.ForecastPreviewUIModel

class WeatherViewAdapter() :
    RecyclerView.Adapter<WeatherViewHolder>() {
    private var list: List<ForecastPreviewUIModel> = listOf()
    var clickListener: ItemClickListener? = null
    fun setOnItemClickListener(clickListener: ItemClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val holder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return WeatherViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = list[position]
        holder.bindWeather(item)
        holder.itemView.setOnClickListener {
            clickListener?.onDetailsClickListener(position)
        }
    }

    fun setList(list: List<ForecastPreviewUIModel>) {
        this.list = list
    }

}