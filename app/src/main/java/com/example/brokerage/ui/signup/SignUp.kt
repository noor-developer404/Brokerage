package com.example.brokerage.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivitySignUpBinding
import com.example.brokerage.ui.signin.SignIn
import com.example.brokerage.ui.userhome.user_home

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupLogin.setOnClickListener {
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
        binding.signupNextBtn.setOnClickListener {
            val intent = Intent(this,user_home::class.java)
            startActivity(intent)
        }
    }
}