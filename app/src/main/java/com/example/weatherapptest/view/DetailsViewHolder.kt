package com.example.weatherapptest.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList

class DetailsViewHolder(itemView: View) : ViewHolder(itemView) {
    private val date = itemView.findViewById<TextView>(R.id.date_time_details)
    private val tempMax = itemView.findViewById<TextView>(R.id.temp_max_details)
    private val pressure = itemView.findViewById<TextView>(R.id.pressure_details)
    private val humidity = itemView.findViewById<TextView>(R.id.humidity_details)
    private val windSpeed = itemView.findViewById<TextView>(R.id.wind_speed_details)
    private val clouds = itemView.findViewById<TextView>(R.id.clouds_details)

    fun bindDetails(item: DataList) {
        date.text = item.dt_txt
        tempMax.text = "${item.main.temp_max}°C"
        pressure.text = "${item.main.pressure} hPa"
        humidity.text = "${item.main.humidity}%"
        windSpeed.text = "${item.wind.speed} m/sec"
        clouds.text = "${item.clouds.all}%"

    }
}