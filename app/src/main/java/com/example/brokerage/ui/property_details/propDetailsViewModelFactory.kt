package com.example.brokerage.ui.property_details

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class propDetailsViewModelFactory(var context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return propDetailsViewModel(context) as T
    }
}