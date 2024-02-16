package com.example.brokerage.ui.newmeetingpopup

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.brokerage.R
import java.util.*

class New_Meeting_Popup : AppCompatActivity() {

    private lateinit var dateButton: ImageView
   private lateinit var dateText : TextView

    private lateinit var btnTimePicker: ImageView
    private lateinit var tvTime : TextView

    private lateinit var btnEndTimePicker: ImageView
    private lateinit var tvEndTime : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_meeting_popup)

        //starttimepicker
        tvTime = findViewById(R.id.tvTime)
        btnTimePicker = findViewById(R.id.btnTimePicker)

        btnTimePicker.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    val amPm: String
                    var adjustedHour = hourOfDay
                    if (hourOfDay < 12) {
                        amPm = "AM"
                    } else {
                        amPm = "PM"
                        // Convert 24-hour format to 12-hour format
                        if (hourOfDay > 12) {
                            adjustedHour -= 12
                        }
                    }

                    tvTime.text = String.format(Locale.getDefault(), "%02d:%02d %s", adjustedHour, minute, amPm)
                },
                startHour,
                startMinute,
                false
            ).show()
        }
        //endtimepicker
        tvEndTime = findViewById(R.id.tvEndTime)
        btnEndTimePicker = findViewById(R.id.btnEndTimePicker)

        btnEndTimePicker.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val endHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val endMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    val amPm: String
                    var adjustedHour = hourOfDay
                    if (hourOfDay < 12) {
                        amPm = "AM"
                    } else {
                        amPm = "PM"
                        // Convert 24-hour format to 12-hour format
                        if (hourOfDay > 12) {
                            adjustedHour -= 12
                        }
                    }

                    tvEndTime.text = String.format(Locale.getDefault(), "%02d:%02d %s", adjustedHour, minute, amPm)
                },
                endHour,
                endMinute,
                false
            ).show()
        }

        //datepicker

        dateButton = findViewById(R.id.dateButton)
        dateText = findViewById(R.id.dateText)

        //take year, month and day from calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //on click open calendar
        dateButton.setOnClickListener {
            //open datePicker dialog


            val dpd = DatePickerDialog(this, {view , myear, mmonth, mday ->
               // set the date to textview
               dateText.text = " $myear/${mmonth + 1}/$mday"   //month starts from 0 so add 1

            },year, month, day).show()
        }



    }
}

