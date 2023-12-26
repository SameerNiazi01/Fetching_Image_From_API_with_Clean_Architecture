package com.example.flowpratice.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    var baseUrl:String="https://pixabay.com/"
    fun ServiceConnection(): ApiInterface {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterface::class.java)
    }
}