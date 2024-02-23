package com.example.brokerage.ui.userhome

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.brokerage.R
import com.example.brokerage.ui.filter.filter
import com.example.brokerage.ui.property_details.property_details
import com.example.brokerage.ui.propertylisting.PropertyListingActivity

class UserHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_home, container, false)
        // Inflate the layout for this fragment

        view.findViewById<ConstraintLayout>(R.id.property1).setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            startActivity(intent)
        }
        view.findViewById<ConstraintLayout>(R.id.property2).setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            startActivity(intent)
        }
        view.findViewById<ConstraintLayout>(R.id.property3).setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            startActivity(intent)
        }
        view.findViewById<ConstraintLayout>(R.id.property4).setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            startActivity(intent)
        }
        view.findViewById<ConstraintLayout>(R.id.property5).setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            startActivity(intent)
        }
        view.findViewById<ConstraintLayout>(R.id.property6).setOnClickListener {
            val intent = Intent(context, property_details::class.java)
            startActivity(intent)
        }
        view.findViewById<ConstraintLayout>(R.id.userHomeFilter).setOnClickListener {
            val intent = Intent(context, filter::class.java)
            startActivity(intent)
        }

        view.findViewById<TextView>(R.id.userhome_viewall_latest).setOnClickListener {
            val intent = Intent(context, PropertyListingActivity::class.java)
            startActivity(intent)
        }

        view.findViewById<TextView>(R.id.userhomeViewallNearby).setOnClickListener {
            val intent = Intent(context, PropertyListingActivity::class.java)
            startActivity(intent)
        }
        view.findViewById<TextView>(R.id.more).setOnClickListener {
            val intent = Intent(context, PropertyListingActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}