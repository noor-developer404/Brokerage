package com.example.brokerage.ui.signin

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivitySignInBinding
import com.example.brokerage.ui.forgotPassword.ForgotPassword
import com.example.brokerage.ui.signup.SignUp
import com.example.brokerage.ui.userhome.user_home
import com.google.android.material.button.MaterialButton

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
        binding.LoginLoginBtn.setOnClickListener {
            val intent = Intent(this,user_home::class.java)
            startActivity(intent)
        }
        binding.signinRegister.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }
    }
}