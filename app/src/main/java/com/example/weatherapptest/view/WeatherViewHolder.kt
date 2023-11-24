package com.example.weatherapptest.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList
import com.example.weatherapptest.data.model.ForecastPreviewUIModel

class WeatherViewHolder(itemView: View) : ViewHolder(itemView) {
    private val date = itemView.findViewById<TextView>(R.id.tv_date)
    private val temp = itemView.findViewById<TextView>(R.id.tv_temp)
    private val clouds = itemView.findViewById<TextView>(R.id.tv_clouds)
    private val relativeHumidity = itemView.findViewById<TextView>(R.id.tv_relative_humidity)
    private val atmosphericPressure = itemView.findViewById<TextView>(R.id.tv_atmospheric_pressure)
    private val windSpeed = itemView.findViewById<TextView>(R.id.tv_wind_speed)

    fun bindWeather(item: ForecastPreviewUIModel) {
        date.text = item.date
        temp.text = "${item.temp_max}°C/${item.temp_min}°C"
        clouds.text = "${item.clouds}%"
        relativeHumidity.text = "${item.humidity}%"
        atmosphericPressure.text = "${item.pressure}hPa"
        windSpeed.text = "${item.windSpeed}meter/sec"

    }
}