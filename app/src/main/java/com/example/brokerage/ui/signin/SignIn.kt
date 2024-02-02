package com.example.brokerage.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivitySignInBinding
import com.example.brokerage.ui.forgotPassword.ForgotPassword

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginForgotPass.setOnClickListener {
            val intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
        }
    }
}