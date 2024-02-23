package com.example.brokerage.ui.userhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityUserHomeBinding
import com.example.brokerage.ui.filter.filter
import com.example.brokerage.ui.property_details.property_details
import com.example.brokerage.ui.propertylisting.PropertyListingActivity

class user_home : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var ivDrawer: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var binding: ActivityUserHomeBinding

        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar));
        supportActionBar?.title =null

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.property1.setOnClickListener {
            val intent = Intent(this, property_details::class.java)
            startActivity(intent)
        }
        binding.property2.setOnClickListener {
            val intent = Intent(this, property_details::class.java)
            startActivity(intent)
        }
        binding.property3.setOnClickListener {
            val intent = Intent(this, property_details::class.java)
            startActivity(intent)
        }
        binding.property4.setOnClickListener {
            val intent = Intent(this,property_details::class.java)
            startActivity(intent)
        }
        binding.property5.setOnClickListener {
            val intent = Intent(this, property_details::class.java)
            startActivity(intent)
        }
        binding.property6.setOnClickListener {
            val intent = Intent(this, property_details::class.java)
            startActivity(intent)
        }

        binding.userHomeFilter.setOnClickListener {
            val intent = Intent(this, filter::class.java)
            startActivity(intent)
        }
        binding.userhomeViewallLatest.setOnClickListener {
            val intent = Intent(this, PropertyListingActivity::class.java)
            startActivity(intent)
        }
        binding.userhomeViewallNearby.setOnClickListener {
            val intent = Intent(this,PropertyListingActivity::class.java)
            startActivity(intent)
        }
        binding.more.setOnClickListener {
            val intent = Intent(this,PropertyListingActivity ::class.java)
            startActivity(intent)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)

    }
}