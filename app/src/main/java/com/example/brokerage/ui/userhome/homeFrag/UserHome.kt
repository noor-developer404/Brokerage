package com.example.brokerage.ui.userhome.homeFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.brokerage.R

class UserHome : Fragment(),View.OnClickListener {

    lateinit var user_home_viewmodel: userHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_home, container, false)
        // Inflate the layout for this fragment
        user_home_viewmodel = ViewModelProvider(this, userHomeViewModelFactory(context)).get(userHomeViewModel::class.java)
        user_home_viewmodel.setLatestProp(view.findViewById(R.id.latestPropRV))
        user_home_viewmodel.setNearbyProp(view.findViewById(R.id.nearbyPropRV))
        user_home_viewmodel.setFeaturedProp(view.findViewById(R.id.featuredPropRV))


        return view
    }

    override fun onClick(v: View?) {

    }
}