package com.example.brokerage.utils

import com.example.brokerage.models.loginModel
import com.example.brokerage.models.wallModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface {

    @Headers("JCBSERVICEAPI:MakeInJcb")
    @FormUrlEncoded
    @POST("tokenRecdApp.php")
    fun login(
        @Field("phoneNo") field1: String,
        @Field("emailId") field2: String,
        @Field("token") field3: String,
        @Field("password") field4: String,
        @Field("fromDevice") field5: String,
        @Field("appversion") field6: String
    ): Call<loginModel>


    @GET("fetch.php")
    fun getWalls(): Call<wallModel>
//        @Field("q") q:String,
//        @Field("from") from:String,
//        @Field("sortBy") sortBy:String,
//        @Field("apiKey") apiKey:String,


}