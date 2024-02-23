package com.example.brokerage.ui.meeting_schedule

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivityMeetingScheduleBinding
import com.google.android.material.tabs.TabLayoutMediator



class meeting_schedule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val tabList = arrayOf("Upcoming","Completed","Cancelled")
        lateinit var binding:ActivityMeetingScheduleBinding

        super.onCreate(savedInstanceState)

        binding= ActivityMeetingScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val scheduleEventButton: Button = findViewById(R.id.scheduleEventButton)

        var dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_new_meeting_popup)


        scheduleEventButton.setOnClickListener {

            dialog.show()
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.BLACK))
            dialog.window?.setGravity(Gravity.BOTTOM)

        }

        val adapter = FragmentAdapter1(supportFragmentManager, lifecycle)

        binding.vpMeet.adapter = adapter

        TabLayoutMediator(binding.tabLayoutMeet,binding.vpMeet){tab,position ->
            tab.text=tabList[position]
        }.attach()

    }
}
