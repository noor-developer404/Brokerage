package com.example.brokerage.ui.messagebox

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R

class ChatRecyclerAdapter : RecyclerView.Adapter<ChatRecyclerAdapter.holder> {
    lateinit var context:Context
    lateinit var chat: List<String>

    constructor(context: Context,chat:List<String>) : super() {
        this.context = context
        this.chat=chat
    }

    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chatview= itemView.findViewById<TextView>(R.id.chatmsg)
        val parent=itemView.findViewById<LinearLayout>(R.id.chat_txt_item)
        val cardView = itemView.findViewById<CardView>(R.id.chatCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        return holder(LayoutInflater.from(context).inflate(R.layout.chat_list_item, parent,false))
    }

    override fun getItemCount(): Int {
        return chat.size
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        if (position%2==0){
            holder.cardView.setCardBackgroundColor(context.resources.getColor(R.color.gray_light))
            holder.parent.gravity = Gravity.RIGHT
            holder.parent.setHorizontalGravity(Gravity.RIGHT)
            holder.chatview.text=chat[position]
        }else{
            holder.cardView.setCardBackgroundColor(context.resources.getColor(R.color.color1))

            holder.chatview.text=chat[position]
            holder.parent.gravity = Gravity.LEFT
            holder.parent.setHorizontalGravity(Gravity.LEFT)
        }

    }
}