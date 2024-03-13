package com.example.brokerage.utils

import com.example.brokerage.utils.Constants.LOGIN_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    var apiInterface: APIInterface
    lateinit var BASE_URL:String

    constructor(base_url: String) {
        this.BASE_URL = base_url
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(APIInterface::class.java)
    }


    fun getInstance():RetrofitInstance{
        return RetrofitInstance(BASE_URL)
    }
}