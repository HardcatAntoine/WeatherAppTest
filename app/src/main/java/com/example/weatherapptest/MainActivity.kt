package com.example.weatherapptest

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
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
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION &&
//            grantResults.isNotEmpty() &&
//            grantResults[0] == PackageManager.PERMISSION_GRANTED
//        ) {
//           // startLocationUpdates()
//        } else {
//            Toast.makeText(
//                this,
//                "Location permission denied",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }



    companion object {
        private const val REQUEST_CODE_LOCATION_PERMISSION = 100
    }
}
