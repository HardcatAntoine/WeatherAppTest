package com.example.weatherapptest.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.weatherapptest.R
import com.example.weatherapptest.data.model.DataList
import com.example.weatherapptest.data.model.Weather

class WeatherViewHolder(itemView: View) : ViewHolder(itemView) {
    private val weatherImage = itemView.findViewById<ImageView>(R.id.im_weather)
    private val date = itemView.findViewById<TextView>(R.id.tv_date)
    private val temp = itemView.findViewById<TextView>(R.id.tv_temp)
    private val clouds = itemView.findViewById<TextView>(R.id.tv_clouds)
    private val relativeHumidity = itemView.findViewById<TextView>(R.id.tv_relative_humidity)
    private val atmosphericPressure = itemView.findViewById<TextView>(R.id.tv_atmospheric_pressure)
    private val windSpeed = itemView.findViewById<TextView>(R.id.tv_wind_speed)

    fun bindWeather(item: DataList) {

        date.text = item.dt_txt
        temp.text = "${item.main.temp_min}/${item.main.temp_max}"
        clouds.text = item.clouds.all.toString()
        relativeHumidity.text = item.main.humidity.toString()
        atmosphericPressure.text = item.main.pressure.toString()
        windSpeed.text = item.wind.speed.toString()

    }
}