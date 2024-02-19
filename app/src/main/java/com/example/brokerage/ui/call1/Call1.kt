package com.example.brokerage.ui.call1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityCall1Binding

class Call1 : AppCompatActivity() {
    lateinit var binding:ActivityCall1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCall1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHangUp.setOnClickListener {
            this.finish()
        }
        binding.call1Backbtn.setOnClickListener {
            this.finish()
        }
    }
}