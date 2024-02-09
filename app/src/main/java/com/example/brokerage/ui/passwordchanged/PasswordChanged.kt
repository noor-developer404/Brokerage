package com.example.brokerage.ui.passwordchanged

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityPasswordChangedBinding
import com.example.brokerage.ui.otpvalidation.OTPvalidation
import com.example.brokerage.ui.signin.SignIn

class PasswordChanged : AppCompatActivity() {
    lateinit var binding: ActivityPasswordChangedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordChangedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToLogin.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}