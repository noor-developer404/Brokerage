package com.example.brokerage.ui.forgotPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityForgotPasswordBinding
import com.example.brokerage.ui.otpvalidation.OTPvalidation
import com.example.brokerage.ui.signin.SignIn
import com.example.brokerage.ui.signup.SignUp

class ForgotPassword : AppCompatActivity() {
    lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendCodeBtn.setOnClickListener {
            val intent = Intent(this,OTPvalidation::class.java)
            startActivity(intent)
        }
        binding.Login.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
        binding.BackF.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}