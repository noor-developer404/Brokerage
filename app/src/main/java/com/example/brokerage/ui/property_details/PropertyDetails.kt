package com.example.brokerage.ui.property_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityPropertyDetailsBinding

class PropertyDetails : AppCompatActivity() {
    lateinit var binding:ActivityPropertyDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPropertyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.propertiesDetailsBackBtn.setOnClickListener {
            this.finish()
        }
    }
}