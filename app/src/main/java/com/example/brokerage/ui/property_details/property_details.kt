package com.example.brokerage.ui.property_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityPropertyDetailsBinding
import com.example.brokerage.ui.bid.BidActivity
import com.example.brokerage.ui.call1.Call1

class property_details : AppCompatActivity() {

    lateinit var binding: ActivityPropertyDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.propertiesDetailsBackBtn.setOnClickListener {
            this.finish()
        }
        binding.btnBidNow.setOnClickListener {
            val intent = Intent(this,BidActivity::class.java)
            startActivity(intent)
        }
        binding.btnCallNow.setOnClickListener {
            val intent = Intent(this,Call1::class.java)
            startActivity(intent)
        }
    }
}