package com.example.sopt_semina_assignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333") .addConverterFactory(GsonConverterFactory.create()) .build()
    var service: RequestInterface = retrofit.create(RequestInterface::class.java) }