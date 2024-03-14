package com.example.brokerage.ui.property_details

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso

class propDetailsViewModel(var context: Context) :ViewModel() {

    fun setData(intent:Intent,imgView:ImageView,rating:TextView,type:TextView){
        Picasso.get().load(intent.getStringExtra("img")).into(imgView)
        rating.text=intent.getStringExtra("rating")
        type.text=intent.getStringExtra("category")
//        Toast.makeText(context,intent.getStringExtra("img"),Toast.LENGTH_SHORT).show()
    }
}