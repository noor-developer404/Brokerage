package com.example.brokerage.ui.property_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityPropertyDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator
import android.content.Intent
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import com.example.brokerage.models.wallModel
import com.example.brokerage.models.wallModelItem
import com.example.brokerage.ui.bid.BidActivity
import com.example.brokerage.ui.call1.Call1
import com.example.brokerage.ui.signup.SignUp
import com.example.brokerage.ui.userhome.user_home

class property_details : AppCompatActivity() {
    val nameList = arrayOf("Details","Gallery","Reviews")
    lateinit var binding:ActivityPropertyDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPropertyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val propViewModel = ViewModelProvider(this,propDetailsViewModelFactory(this)).get(propDetailsViewModel::class.java)
        propViewModel.setData(intent,binding.propDetailsImg,binding.propDetailsRating,binding.propDetailsType)

        binding.propertiesDetailsBackBtn.setOnClickListener {
            val intent = Intent(this, user_home::class.java)
            startActivity(intent)
        }
        val adapter = FragmentAdapter(supportFragmentManager,lifecycle)

        binding.vp2.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.vp2){tab,position ->
            tab.text=nameList[position]
        }.attach()

    }
}