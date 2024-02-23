package com.example.brokerage.ui.propertydirection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityAgentNearbyBinding
import com.example.brokerage.databinding.ActivityPropertyDirectionBinding
import com.example.brokerage.ui.filter.filter

class PropertyDirection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityPropertyDirectionBinding

        binding = ActivityPropertyDirectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.DirectionFilter.setOnClickListener {
            val intent = Intent(this, filter::class.java)
            startActivity(intent)
        }
    }
}