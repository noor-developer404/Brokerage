package com.example.brokerage.ui.agentDashboard

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityAgentDashboardBinding
import com.example.brokerage.databinding.ActivityMeetingsBinding
import com.example.brokerage.databinding.ActivityUserHomeBinding
import com.example.brokerage.ui.meeting_schedule.meeting_schedule
import com.example.brokerage.ui.meetings.meetings
import com.example.brokerage.ui.property_details.property_details

class AgentDashboard : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityAgentDashboardBinding

        super.onCreate(savedInstanceState)
        binding = ActivityAgentDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.meetings.setOnClickListener {
//            val intent = Intent(this, meetings ::class.java)
//            startActivity(intent)
//        }


        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = null

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController(R.id.agent_fragHost)
        NavigationUI.setupWithNavController(binding.agentBtmbar,navController)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}
