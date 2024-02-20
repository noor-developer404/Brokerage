package com.example.brokerage.ui.property_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityPropertyDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator
import android.content.Intent
import com.example.brokerage.ui.bid.BidActivity
import com.example.brokerage.ui.call1.Call1

class property_details : AppCompatActivity() {
    val nameList = arrayOf("Details","Gallery","Reviews")
    lateinit var binding:ActivityPropertyDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPropertyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = FragmentAdapter(supportFragmentManager,lifecycle)

        binding.vp2.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.vp2){tab,position ->
            tab.text=nameList[position]
        }.attach()

    }
}