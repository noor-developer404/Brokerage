package com.example.brokerage.ui.bid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.brokerage.R

class BidActivity : AppCompatActivity() {

    private var count = 45000 // Initial value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bid)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        val valueTextView = findViewById<TextView>(R.id.valueTextView)

        val bid1 = findViewById<TextView>(R.id.bid1)
        bid1.setOnClickListener {
            updateCountFromTextView(bid1, valueTextView)
        }

        val bid2 = findViewById<TextView>(R.id.bid2)
        bid2.setOnClickListener {
            updateCountFromTextView(bid2, valueTextView)
        }

        val bid3 = findViewById<TextView>(R.id.bid3)
        bid3.setOnClickListener {
            updateCountFromTextView(bid3, valueTextView)
        }

        val bid4 = findViewById<TextView>(R.id.bid4)
        bid4.setOnClickListener {
            updateCountFromTextView(bid4, valueTextView)
        }

        // Increment button click listener
        incrementButton.setOnClickListener {
            count++
            updateTextView(valueTextView)
        }

        // Decrement button click listener
        decrementButton.setOnClickListener {
            count--
            updateTextView(valueTextView)
        }
    }

    private fun updateTextView(valueTextView: TextView) {
        valueTextView.text = String.format("%,d", count) + " AED"
    }

    private fun updateCountFromTextView(textView: TextView, valueTextView: TextView) {
        try {

            valueTextView.text= textView.text
//            count = textView.text.toString().replace(",", "").toInt()
//            updateTextView(valueTextView)  // Add the parameter here
        } catch (e: NumberFormatException) {
            // Handle the case where the conversion fails
            // You may want to log the error or set a default value for count
        }
    }


    private fun updateTextView() {
        findViewById<TextView>(R.id.valueTextView).text = String.format("%,d", count) + " AED"
    }
}
