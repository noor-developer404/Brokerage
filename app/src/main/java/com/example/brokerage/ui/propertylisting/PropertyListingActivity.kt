package com.example.brokerage.ui.propertylisting

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R

class PropertyListingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PropertyListAdapter
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_listing)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.property_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter
        adapter = PropertyListAdapter(emptyList(),this)
        recyclerView.adapter = adapter

        // Placeholder data (Update when API is available)
        val placeholderData = getPlaceholderData()
        adapter.updateData(placeholderData)
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
    }

    private fun getPlaceholderData(): List<Property> {
        val properties = mutableListOf<Property>()
        properties.add(Property("Starting AED 1,300,000", "Meraas Le Pont Villas", R.drawable.house));
        properties.add(Property("Starting AED 1,300,000", "La Vie at JBR Dubai", R.drawable.propertyimg1));
        properties.add(Property("Starting AED 1,300,000", "Meraas Le Pont Villas", R.drawable.house));
        properties.add(Property("Starting AED 1,300,000", "La Vie at JBR Dubai", R.drawable.propertyimg1));
        properties.add(Property("Starting AED 1,300,000", "Meraas Le Pont Villas", R.drawable.house))



        // Add more placeholder data as needed
        return properties
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)

    }
    data class Property(val text: String, val title: String, val imageResource: Int)
}

// Data Class
