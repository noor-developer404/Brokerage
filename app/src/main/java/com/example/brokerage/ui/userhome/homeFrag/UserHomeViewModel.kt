package com.example.brokerage.ui.userhome.homeFrag

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.models.newsModel
import com.example.brokerage.utils.Constants.NEWS_BASE_URL
import com.example.brokerage.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class userHomeViewModel(var context:Context?): ViewModel() {
    fun setLatestProp(rv:RecyclerView){
        RetrofitInstance(NEWS_BASE_URL).getInstance().apiInterface.getNews()
            .enqueue(object: Callback<newsModel>{
                override fun onResponse(call: Call<newsModel>, response: Response<newsModel>) {
                    Log.e("news", "onResponse: "+response.body()?.articles )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = latestPropAdapter(context, response.body()!!.articles)
                }
                override fun onFailure(call: Call<newsModel>, t: Throwable) {
                    Log.e("news", "onFailure: "+t.toString() )
                }
            })
    }
    fun setNearbyProp(rv:RecyclerView){
        RetrofitInstance(NEWS_BASE_URL).getInstance().apiInterface.getNews()
            .enqueue(object: Callback<newsModel>{
                override fun onResponse(call: Call<newsModel>, response: Response<newsModel>) {
                    Log.e("news", "onResponse: "+response.body()?.articles )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = latestPropAdapter(context, response.body()!!.articles)
                }
                override fun onFailure(call: Call<newsModel>, t: Throwable) {
                    Log.e("news", "onFailure: "+t.toString() )
                }
            })
    }
    fun setFeaturedProp(rv:RecyclerView){
        RetrofitInstance(NEWS_BASE_URL).getInstance().apiInterface.getNews()
            .enqueue(object: Callback<newsModel>{
                override fun onResponse(call: Call<newsModel>, response: Response<newsModel>) {
                    Log.e("news", "onResponse: "+response.body()?.articles )
                    rv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                    rv.adapter = latestPropAdapter(context, response.body()!!.articles)
                }
                override fun onFailure(call: Call<newsModel>, t: Throwable) {
                    Log.e("news", "onFailure: "+t.toString() )
                }
            })
    }

    fun toast(text:String){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
    }
}