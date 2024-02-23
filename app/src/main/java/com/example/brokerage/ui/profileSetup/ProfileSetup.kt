package com.example.brokerage.ui.profileSetup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.brokerage.R
import com.example.brokerage.ui.agentDashboard.AgentDashboard
import com.example.brokerage.ui.brokerDashboard.BrokerDashboard
import com.example.brokerage.ui.userhome.user_home
import com.google.android.material.button.MaterialButton

class ProfileSetup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setup)

        // get reference to the string array that we just created
        val months = resources.getStringArray(R.array.role)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, months)
        // get reference to the autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)


        // get reference to the string array that we just created
        val loc = resources.getStringArray(R.array.location)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter1 = ArrayAdapter(this, R.layout.dropdown_item, loc)
        // get reference to the autocomplete text view
        val autocompleteTVLoc = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewLoc)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTVLoc.setAdapter(arrayAdapter1)
        autocompleteTVLoc


        findViewById<MaterialButton>(R.id.save).setOnClickListener {
//            Toast.makeText(this,autocompleteTV.text,Toast.LENGTH_SHORT).show()
            if (autocompleteTV.text.toString()=="Client"){
                val intent = Intent(this,user_home::class.java)
                startActivity(intent)

            }else if (autocompleteTV.text.toString()=="Agent"){
                val intent = Intent(this,AgentDashboard::class.java)
                startActivity(intent)


            }else if (autocompleteTV.text.toString()=="Broker"){
                val intent = Intent(this,BrokerDashboard::class.java)
                startActivity(intent)

            }else{}
        }


    }
}
