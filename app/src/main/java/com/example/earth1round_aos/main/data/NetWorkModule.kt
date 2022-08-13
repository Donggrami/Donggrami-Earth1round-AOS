package com.example.earth1round_aos.main.data

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://3.37.73.80:8082"

fun getRetrofit(): Retrofit{
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    return retrofit
}