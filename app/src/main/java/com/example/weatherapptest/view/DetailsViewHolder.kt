package com.example.weatherapptest.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.SingleDayForecast

class DetailsViewHolder(itemView: View) : ViewHolder(itemView) {
    private val date = itemView.findViewById<TextView>(R.id.date_time_details)
    private val tempMax = itemView.findViewById<TextView>(R.id.temp_max_details)
    private val tempMin = itemView.findViewById<TextView>(R.id.temp_min_details)
    private val pressure = itemView.findViewById<TextView>(R.id.pressure_details)
    private val humidity = itemView.findViewById<TextView>(R.id.humidity_details)
    private val windSpeed = itemView.findViewById<TextView>(R.id.wind_speed_details)
    private val clouds = itemView.findViewById<TextView>(R.id.clouds_details)

    fun bindDetails(item: SingleDayForecast) {

        item.list.map {
            date.text = it.dt_txt
            tempMin.text = it.main.temp_min.toString()
            tempMax.text = it.main.temp_max.toString()
            pressure.text = it.main.pressure.toString()
            humidity.text = it.main.humidity.toString()
            windSpeed.text = it.wind.speed.toString()
            clouds.text = it.clouds.all.toString()
        }
    }
}