package com.example.weatherapptest.view

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager

class LocationService(
    context: Context,
    private val onLocationReady: (Location) -> Unit
) : LocationListener {
    private val locationManager: LocationManager

    init {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            REQUEST_INTERVAL_MILLIS.toLong(),
            0f,
            this
        )
    }

    override fun onLocationChanged(location: Location) {
        onLocationReady(location)
    }

    fun clearListener() {
        locationManager.removeUpdates(this)
    }

    companion object {
        const val REQUEST_INTERVAL_MILLIS = 1000 * 60 * 60 * 12
    }
}