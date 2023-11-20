package com.example.weatherapptest.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList

class WeatherViewHolder(itemView: View) : ViewHolder(itemView) {
    private val date = itemView.findViewById<TextView>(R.id.tv_date)
    private val temp = itemView.findViewById<TextView>(R.id.tv_temp)
    private val clouds = itemView.findViewById<TextView>(R.id.tv_clouds)
    private val relativeHumidity = itemView.findViewById<TextView>(R.id.tv_relative_humidity)
    private val atmosphericPressure = itemView.findViewById<TextView>(R.id.tv_atmospheric_pressure)
    private val windSpeed = itemView.findViewById<TextView>(R.id.tv_wind_speed)

    fun bindWeather(item: DataList) {
        date.text = item.dt_txt
        temp.text = "${item.main.temp_min}°C/${item.main.temp_max}°C"
        clouds.text = "${item.clouds.all}%"
        relativeHumidity.text = "${item.main.humidity}%"
        atmosphericPressure.text = "${item.main.pressure}hPa"
        windSpeed.text = "${item.wind.speed}meter/sec"

    }
}