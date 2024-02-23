package com.example.brokerage.ui.otpvalidation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityOtpvalidationBinding
import com.example.brokerage.ui.forgotPassword.ForgotPassword
import com.example.brokerage.ui.passwordchanged.PasswordChanged

class OTPvalidation : AppCompatActivity() {

    lateinit var binding: ActivityOtpvalidationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpvalidationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verifyBtn.setOnClickListener {
            val intent = Intent(this,PasswordChanged::class.java)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            val intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
        }
    }
}