package com.example.brokerage.ui.userhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityUserHomeBinding
import com.example.brokerage.ui.property_details.property_details

class user_home : AppCompatActivity() {
    lateinit var binding:ActivityUserHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.property1.setOnClickListener {
            val intent = Intent(this,property_details::class.java)
            startActivity(intent)
        }
        binding.property4.setOnClickListener {
            val intent = Intent(this,property_details::class.java)
            startActivity(intent)
        }
        binding.property3.setOnClickListener {
            val intent = Intent(this,property_details::class.java)
            startActivity(intent)
        }
    }
}