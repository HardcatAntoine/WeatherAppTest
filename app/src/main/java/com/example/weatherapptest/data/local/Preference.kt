package com.example.weatherapptest.data.local

import android.content.Context
import androidx.core.content.edit
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class Preference @Inject constructor(@ApplicationContext private val context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveLatitude(latitude: String) {
        sharedPreferences.edit { putString(LAT_KEY, latitude) }
    }

    fun saveLongitude(longitude: String) {
        sharedPreferences.edit { putString(LON_KEY, longitude) }
    }

    fun getSavedLatitude(): String? {
        return sharedPreferences.getString(LAT_KEY, null)
    }

    fun getSavedLongitude(): String? {
        return sharedPreferences.getString(LON_KEY, null)
    }

    companion object {
        const val LAT_KEY = "lat"
        const val LON_KEY = "lon"
    }
}