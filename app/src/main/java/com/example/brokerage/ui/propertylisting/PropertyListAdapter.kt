package com.example.brokerage.ui.propertylisting

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.ui.bid.BidActivity
import com.example.brokerage.ui.filter.filter
import com.example.brokerage.ui.property_details.property_details

class PropertyListAdapter(private var properties: List<PropertyListingActivity.Property>, var context:Context) :
    RecyclerView.Adapter<PropertyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_property_listing, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = properties[position]
        holder.propertyText.text = property.text
        holder.propertyTitle.text = property.title
        holder.propertyImage.setImageResource(property.imageResource)

        holder.bid_btn.setOnClickListener {
            val intent = Intent(context, BidActivity::class.java)
            context.startActivity(intent)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return properties.size
    }

    fun updateData(newProperties: List<PropertyListingActivity.Property>) {
        properties = newProperties
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val propertyImage: ImageView = itemView.findViewById(R.id.property_image)
        val propertyText: TextView = itemView.findViewById(R.id.goldText)
        val propertyTitle: TextView = itemView.findViewById(R.id.property_title)
        val bid_btn= itemView.findViewById<Button>(R.id.bid_button)
    }
}