package com.example.brokerage.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.brokerage.databinding.ActivitySignInBinding
import com.example.brokerage.ui.contacts.Contact_Fetch_Activity
import com.example.brokerage.ui.forgotPassword.ForgotPassword
import com.example.brokerage.ui.profileSetup.ProfileSetup
import com.example.brokerage.ui.signup.SignUp
import com.example.brokerage.ui.userhome.user_home

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginForgotPass.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        binding.signinLoginBtn.setOnClickListener {
            val intent = Intent(this, ProfileSetup::class.java)
            startActivity(intent)
//            val email = binding.enterEmail.text.toString().trim()
//            val password = binding.enterpass.text.toString().trim()
//            if (email=="" || password==""){
//                // Check if the entered credentials are valid
//                Toast.makeText(this,"Enter Email and Password",Toast.LENGTH_LONG).show()
//            }else{
//                if (email == "brokerage@gmail.com" && password == "12345678") {
//                    // Navigate to user_home
//                    val intent = Intent(this, ProfileSetup::class.java)
//                    startActivity(intent)
//                } else {
//                    // Show login failed toast
//                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
//                }
//            }
        }

//        binding.signinRegister.setOnClickListener {
//            val intent = Intent(this, SignUp::class.java)
//            startActivity(intent)
//        }

        binding.signinRegister.setOnClickListener {
            val intent = Intent(this, Contact_Fetch_Activity::class.java)
            startActivity(intent)
        }
    }
}