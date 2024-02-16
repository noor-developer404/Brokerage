package com.example.brokerage.ui.propertylisting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R

class PropertyListingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PropertyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_listing)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.property_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter
        adapter = PropertyListAdapter(emptyList())
        recyclerView.adapter = adapter

        // Placeholder data (Update when API is available)
        val placeholderData = getPlaceholderData()
        adapter.updateData(placeholderData)
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
}

// Data Class
data class Property(val text: String, val title: String, val imageResource: Int)

