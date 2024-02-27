package com.example.brokerage.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import org.json.JSONArray
import org.json.JSONObject

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.holder> {
    lateinit var data:JSONArray

    constructor(data: JSONArray) : super() {
        this.data = data
    }

    class holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.contact_item_img)
        val name = itemView.findViewById<TextView>(R.id.contact_item_name)
        val email = itemView.findViewById<TextView>(R.id.contact_item_email)
        val num = itemView.findViewById<TextView>(R.id.contact_item_phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item_view,parent,false)
        return holder(view)
    }

    override fun getItemCount(): Int {
       return data.length()
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        val itemObject :JSONObject = data.getJSONObject(position)
        holder.name.text=itemObject.get("name").toString()
        holder.email.text=itemObject.get("email").toString()
        holder.num.text=itemObject.get("phone").toString()

    }
}