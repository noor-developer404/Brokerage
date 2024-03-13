package com.example.brokerage.ui.userhome.homeFrag

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.models.Article
import com.squareup.picasso.Picasso

class latestPropAdapter: RecyclerView.Adapter<latestPropAdapter.holder> {
    var context: Context?
    var articles:List<Article>

    constructor(context: Context?, articles: List<Article>) : super() {
        this.context = context
        this.articles = articles
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
        Picasso.get().load(articles.get(position).urlToImage).into(holder.img)
        holder.title.text=articles.get(position).title
    }
}