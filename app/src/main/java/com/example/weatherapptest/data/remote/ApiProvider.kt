package com.example.weatherapptest.data.remote

import com.example.weatherapptest.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    private val gsonConverter = GsonConverterFactory.create()
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(gsonConverter)
        .build()
    private val api = retrofit.create(ApiService::class.java)
    val apiService: ApiService
        get() = api
}