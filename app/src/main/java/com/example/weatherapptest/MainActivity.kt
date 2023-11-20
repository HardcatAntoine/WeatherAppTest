package com.example.weatherapptest

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import com.example.weatherapptest.data.local.Preference
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener

    @Inject
    lateinit var preference: Preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_main -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.weatherFragment)
                    true
                }

                R.id.page_second -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.locationFragment)
                    true
                }

                R.id.page_third -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.locationFragment)
                    true
                }

                R.id.page_fourth -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.locationFragment)
                    true
                }

                R.id.page_fifth -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.locationFragment)
                    true
                }

                else -> false
            }
        }
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                val latitude = location.latitude.toString()
                val longitude = location.longitude.toString()
                preference.saveLatitude(latitude)
                preference.saveLongitude(longitude)
                // Действия при получении новой геопозиции
                Log.d(
                    "GAY LOCATION",
                    "Latitude: $latitude, Longitude: $longitude",
                )
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        // Включение обновлений геопозиции
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION_PERMISSION
            )
        } else {
            startLocationUpdates()
        }
    }

    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION_PERMISSION
            )
        } else {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MIN_TIME_BW_UPDATES,
                MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(),
                locationListener
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION &&
            grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            startLocationUpdates()
        } else {
            Toast.makeText(
                this,
                "Location permission denied",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        locationManager.removeUpdates(locationListener)
    }


    companion object {
        private const val REQUEST_CODE_LOCATION_PERMISSION = 100
        private const val MIN_TIME_BW_UPDATES: Long = 1000 // 1 second
        private const val MIN_DISTANCE_CHANGE_FOR_UPDATES = 10 // 10 meters
    }
}
