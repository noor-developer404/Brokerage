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
    private lateinit var valueTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bid)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        valueTextView = findViewById<TextView>(R.id.valueTextView)

        val bid1 = findViewById<TextView>(R.id.bid1)
        val bid2 = findViewById<TextView>(R.id.bid2)
        val bid3 = findViewById<TextView>(R.id.bid3)
        val bid4 = findViewById<TextView>(R.id.bid4)

        // Update the display initially
        updateTextView()

        // Set click listeners
        bid1.setOnClickListener {
            updateCountFromTextView(bid1)
        }

        bid2.setOnClickListener {
            updateCountFromTextView(bid2)
        }

        bid3.setOnClickListener {
            updateCountFromTextView(bid3)
        }

        bid4.setOnClickListener {
            updateCountFromTextView(bid4)
        }

        incrementButton.setOnClickListener {
            count++
            updateTextView()
        }

        decrementButton.setOnClickListener {
            if (count > 0) {
                count--
                updateTextView()
            } else {
                // Display a toast message or handle the case where count is already at minimum
                Toast.makeText(this, "Minimum value reached", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateTextView() {
        valueTextView.text = String.format("%,d", count) + " AED"
    }

    private fun updateCountFromTextView(textView: TextView) {
        try {
            count = textView.text.toString().replace("k", "000").replace(",", "").split(" ")[0].toInt()
            updateTextView()
        } catch (e: NumberFormatException) {

        }
    }
}
