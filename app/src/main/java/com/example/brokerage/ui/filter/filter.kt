package com.example.brokerage.ui.filter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityFilterBinding
import com.example.brokerage.ui.property_details.property_details


class filter : AppCompatActivity() {
    lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.filterApply.setOnClickListener {
            this.finish()
        }

        binding.filterBack.setOnClickListener {
            val intent = Intent(this, property_details::class.java)
            startActivity(intent)
        }

//      var House =   findViewById<CardView>(R.id.filterHouse)
//        House.setOnClickListener{
//
//            House.setCardBackgroundColor(R.color.black);
////            House.setBackgroundColor(R.color.color1);
//        }


        //seekbar

        val seek = findViewById<SeekBar>(R.id.seekBar)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped

            }
        })


        //seekbar1


        val seek1 = findViewById<SeekBar>(R.id.seekBar1)
        seek1?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek1: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek1: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek1: SeekBar) {
                // write custom code for progress is stopped

            }
        })
    }
}