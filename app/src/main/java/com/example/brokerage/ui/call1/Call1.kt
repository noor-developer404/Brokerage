package com.example.brokerage.ui.call1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.brokerage.R

class Call1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call1)

        findViewById<ImageView>(R.id.call1_back_btn).setOnClickListener {
            this.finish()
        }
        findViewById<ImageView>(R.id.call1_hang_btn).setOnClickListener {
            this.finish()
        }
    }
}