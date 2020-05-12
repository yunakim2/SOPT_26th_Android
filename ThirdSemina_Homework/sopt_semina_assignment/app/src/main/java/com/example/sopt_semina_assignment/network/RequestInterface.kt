package com.example.sopt_semina_assignment.network


import com.example.sopt_semina_assignment.data.RequestLogin
import com.example.sopt_semina_assignment.data.ResponseLogin
import com.example.sopt_semina_assignment.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>

    @FormUrlEncoded
    @POST("/user/signup")
    fun requestRegister(
        @Field("id") id:String,
        @Field("password") pw:String,
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("phone") phone:String
    ) : Call<ResponseRegister>
}