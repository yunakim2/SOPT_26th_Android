package com.example.a3_semina_assignment_1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RequestInterface {
    @GET("/v3/search/book" )
    fun requestBook(
        @Header("Authorization")  token : String,
        @Query("query") bookname : String

    ) : Call<responseBookData>


}