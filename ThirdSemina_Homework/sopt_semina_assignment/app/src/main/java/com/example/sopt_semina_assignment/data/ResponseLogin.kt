package com.example.sopt_semina_assignment.data

import com.google.gson.annotations.SerializedName

data class ResponseLogin (
    val status : Int,
    val success : Boolean,
    val message : String,
    @SerializedName("data")
    val responseData : SomeData?
)
data class  SomeData(
    val jwt : String
)