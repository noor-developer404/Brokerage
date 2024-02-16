package com.example.brokerage.ui.propertylisting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R

class PropertyListAdapter(private var properties: List<Property>) :
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
    }

    override fun getItemCount(): Int {
        return properties.size
    }

    fun updateData(newProperties: List<Property>) {
        properties = newProperties
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val propertyImage: ImageView = itemView.findViewById(R.id.property_image)
        val propertyText: TextView = itemView.findViewById(R.id.goldText)
        val propertyTitle: TextView = itemView.findViewById(R.id.property_title)
    }
}