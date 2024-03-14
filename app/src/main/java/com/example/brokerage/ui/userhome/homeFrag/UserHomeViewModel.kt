package com.example.brokerage.ui.userhome.homeFrag

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.models.wallModel
import com.example.brokerage.utils.Constants.WALLBOX_BASE_URL
import com.example.brokerage.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class userHomeViewModel(var context:Context?): ViewModel() {
    fun setLatestProp(rv:RecyclerView){
        RetrofitInstance(WALLBOX_BASE_URL).getInstance().apiInterface.getWalls()
            .enqueue(object: Callback<wallModel>{
                override fun onResponse(call: Call<wallModel>, response: Response<wallModel>) {
                    Log.e("wall", "onResponse: "+response.body() )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = latestPropAdapter(context, response.body())
                }
                override fun onFailure(call: Call<wallModel>, t: Throwable) {
                    Log.e("wall", "onFailure: "+t.toString() )
                }
            })
    }
    fun setNearbyProp(rv:RecyclerView){
        RetrofitInstance(WALLBOX_BASE_URL).getInstance().apiInterface.getWalls()
            .enqueue(object: Callback<wallModel>{
                override fun onResponse(call: Call<wallModel>, response: Response<wallModel>) {
                    Log.e("wall", "onResponse: "+response.body() )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = latestPropAdapter(context, response.body())
                }
                override fun onFailure(call: Call<wallModel>, t: Throwable) {
                    Log.e("wall", "onFailure: "+t.toString() )
                }
            })
    }
    fun setFeaturedProp(rv:RecyclerView){
        RetrofitInstance(WALLBOX_BASE_URL).getInstance().apiInterface.getWalls()
            .enqueue(object: Callback<wallModel>{
                override fun onResponse(call: Call<wallModel>, response: Response<wallModel>) {
                    Log.e("wall", "onResponse: "+response.body().toString() )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = latestPropAdapter(context, response.body())
                }
                override fun onFailure(call: Call<wallModel>, t: Throwable) {
                    Log.e("wall", "onFailure: "+t.toString() )
                }
            })
    }

    fun setCitiesRv(rv:RecyclerView){
        RetrofitInstance(WALLBOX_BASE_URL).getInstance().apiInterface.getWalls()
            .enqueue(object: Callback<wallModel>{
                override fun onResponse(call: Call<wallModel>, response: Response<wallModel>) {
                    Log.e("wall", "onResponse: "+response.body().toString() )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = citiesAdapter(context, response.body())
                }
                override fun onFailure(call: Call<wallModel>, t: Throwable) {
                    Log.e("wall", "onFailure: "+t.toString() )
                }
            })
    }

    fun toast(text:String){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
    }
}