package com.example.brokerage.ui.userhome.homeFrag

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.models.wallModel
import com.example.brokerage.utils.Constants
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class citiesAdapter: RecyclerView.Adapter<citiesAdapter.holder> {
    var context: Context?
    var wallList:wallModel?

    constructor(context: Context?, wallList: wallModel?) : super() {
        this.context = context
        this.wallList = wallList
    }


    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ShapeableImageView>(R.id.item_cities_img)
        val name = itemView.findViewById<TextView>(R.id.item_cities_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        return holder(LayoutInflater.from(context).inflate(R.layout.cities_item_rv,parent,false))
    }

    override fun getItemCount(): Int {
      return 10
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        Picasso.get().load(Constants.WALLIMG_BASE_URL +wallList?.get(position)?.wallpaper).into(holder.img)
        holder.name.text=wallList?.get(position)?.category
    }
}