package com.example.databindingfragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ThirdViewModelFactory(private val finalScore: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThirdViewModel::class.java))
            return ThirdViewModel(finalScore) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
