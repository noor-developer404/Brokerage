package com.example.brokerage.ui.messagelist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.ui.messagebox.MessageBox

class MessageAdapter (
    private val context : Context,
    private val images: List<Message>
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {


    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = itemView.findViewById<ImageView>(R.id.img)
        val imgTitle: TextView = itemView.findViewById<TextView>(R.id.img_title)
        val imgMsg: TextView = itemView.findViewById<TextView>(R.id.img_msg)

        fun bindView(message: Message) {
            img.setImageResource(message.ImageSrc)
            imgTitle.text = message.title
          imgMsg.text = message.message


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder =
     MessageViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items1, parent,false))
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
       holder.bindView(images[position])
        holder.itemView.setOnClickListener{
            val intent = Intent(context, MessageBox::class.java)
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int = images.size


}
