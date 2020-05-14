package com.example.a3_semina_assignment_1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl( "https://dapi.kakao.com") .addConverterFactory(GsonConverterFactory.create()) .build()
    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}