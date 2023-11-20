package com.example.weatherapptest.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rain(
    val `3h`: Double
) : Parcelable