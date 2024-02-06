package com.example.brokerage.ui.forgotPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityForgotPasswordBinding
import com.example.brokerage.ui.otpvalidation.OTPvalidation

class ForgotPassword : AppCompatActivity() {
    lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SendCodeBtn.setOnClickListener {
            val intent = Intent(this,OTPvalidation::class.java)
            startActivity(intent)
        }
    }
}