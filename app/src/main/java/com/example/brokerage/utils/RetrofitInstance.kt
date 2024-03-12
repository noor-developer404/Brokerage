package com.example.brokerage.utils

import com.example.brokerage.ui.Constants.LOGIN_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    var apiInterface: APIInterface

    constructor(){
        val retrofit = Retrofit.Builder().baseUrl(LOGIN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(APIInterface::class.java)
    }

    fun getInstance():RetrofitInstance{
        return RetrofitInstance()
    }
}