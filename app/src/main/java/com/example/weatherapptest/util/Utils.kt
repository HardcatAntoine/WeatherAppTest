package com.example.weatherapptest.util

import java.sql.Date
import java.sql.Timestamp

fun convertToDate(timeStamp: Int): Date {
    return Date(Timestamp(timeStamp.toLong()).time)
}