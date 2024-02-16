package com.example.brokerage.ui.meetings

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.CalendarView
import com.example.brokerage.R
import java.util.Calendar

class meetings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meetings)

        val calendarView: CalendarView = findViewById(R.id.calendarView)
        val calendar: Calendar = Calendar.getInstance()

        // Set initial date if needed
        // calendar.set(Calendar.YEAR, initialYear)
        // calendar.set(Calendar.MONTH, initialMonth)
        // calendar.set(Calendar.DAY_OF_MONTH, initialDay)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Handle date selection
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            // Do something with the selected date
            // For example, you can use the calendar instance to get the selected date
            val selectedDate = calendar.time
            // Further actions...

        }

        val scheduleEventButton: Button = findViewById(R.id.scheduleEventButton)

        var dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_new_meeting_popup)


        scheduleEventButton.setOnClickListener {

            dialog.show()
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.BLACK))
            dialog.window?.setGravity(Gravity.BOTTOM)

        }
    }
}