package com.example.brokerage.ui.userhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityUserHomeBinding
import com.example.brokerage.ui.signin.SignIn
import com.example.brokerage.utils.SharedPref
import com.google.android.material.navigation.NavigationView

class user_home : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityUserHomeBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var sp:SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp= SharedPref(this)
        binding.userHomeNav.setNavigationItemSelectedListener(this)
        binding.userHomeNav.bringToFront()
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title =null

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.userDrawerLayout,binding.toolbar, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        binding.userDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val navcontoller = findNavController(R.id.user_home_fragHost)
        NavigationUI.setupWithNavController(binding.userhomeBtmbar,navcontoller)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
        when(item.itemId){
            R.id.user_nav_logout->{
                sp.SP_logout()
                val intent = Intent(this,SignIn::class.java)
                startActivity(intent)
                this.finish()
            }
            R.id.user_nav_settings->{
//                Toast.makeText(this,GoogleSignIn.getLastSignedInAccount(this).toString(),Toast.LENGTH_SHORT).show()
                Toast.makeText(this,sp.sharedPreference.getString("name","")+" "+sp.sharedPreference.getString("email",""),Toast.LENGTH_SHORT).show()
            }
        }
        binding.userDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}