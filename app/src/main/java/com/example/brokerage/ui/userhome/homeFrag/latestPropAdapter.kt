package com.example.brokerage.ui.userhome.homeFrag

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.models.wallModel
import com.example.brokerage.ui.property_details.property_details
import com.example.brokerage.utils.Constants.WALLIMG_BASE_URL
import com.squareup.picasso.Picasso

class latestPropAdapter: RecyclerView.Adapter<latestPropAdapter.holder> {
    var context: Context?
    var wallList:wallModel?

    constructor(context: Context?, wallList: wallModel?) : super() {
        this.context = context
        this.wallList = wallList
    }


    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.PropItemImg)
        val title = itemView.findViewById<TextView>(R.id.PropItemTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        return holder(LayoutInflater.from(context).inflate(R.layout.properties_rv_item, parent, false))
    }

    override fun getItemCount(): Int {
       return 5
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        Picasso.get().load(WALLIMG_BASE_URL+wallList?.get(position)?.wallpaper).into(holder.img)
        holder.title.text=wallList?.get(position)?.category

        val intent = Intent(context,property_details::class.java)
        intent.putExtra("img",WALLIMG_BASE_URL+wallList?.get(position)?.wallpaper)
        intent.putExtra("category",wallList?.get(position)?.category)
        intent.putExtra("rating",wallList?.get(position)?.rating)

        holder.itemView.setOnClickListener {
            context?.startActivity(intent)
        }
    }
}