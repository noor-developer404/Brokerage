package com.example.brokerage.ui.messagelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.ui.Image
import com.example.brokerage.ui.ImageAdapter
import com.example.brokerage.ui.Message
import com.example.brokerage.ui.MessageAdapter

class MessageList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)

        val message = listOf<Message>(
            Message("Milano", "tempor incididunt ut labore et dolore",R.drawable.u1),
            Message("Samuel Ella", "Excepteur sint occaecat cupidatat non",R.drawable.u2),
            Message("Emmet Perry", "Excepteur sint occaecat cupidatat non",R.drawable.u3),
            Message("Walter Lindsey", "Quis nostrud exercitation ullamco",R.drawable.u4),
            Message("Velma Cole", "Excepteur sint occaecat cupidatat non",R.drawable.u5),
            Message("Milano", "tempor incididunt ut labore et dolore",R.drawable.u1),
            Message("Samuel Ella", "Excepteur sint occaecat cupidatat non",R.drawable.u2),
            Message("Emmet Perry", "Excepteur sint occaecat cupidatat non",R.drawable.u3),
            Message("Walter Lindsey", "Quis nostrud exercitation ullamco",R.drawable.u4),
            Message("Velma Cole", "Excepteur sint occaecat cupidatat non",R.drawable.u5),
            Message("Milano", "tempor incididunt ut labore et dolore",R.drawable.u1),
            Message("Samuel Ella", "Excepteur sint occaecat cupidatat non",R.drawable.u2),
            Message("Emmet Perry", "Excepteur sint occaecat cupidatat non",R.drawable.u3),
            Message("Walter Lindsey", "Quis nostrud exercitation ullamco",R.drawable.u4),
            Message("Velma Cole", "Excepteur sint occaecat cupidatat non",R.drawable.u5)

        )
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MessageAdapter(this,message)
    }
}