package com.example.brokerage.ui.userhome.homeFrag

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class userHomeViewModelFactory(var context: Context?):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return userHomeViewModel(context) as T
    }
}