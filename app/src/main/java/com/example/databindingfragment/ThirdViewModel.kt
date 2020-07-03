package com.example.databindingfragment

import android.util.Log
import androidx.lifecycle.ViewModel

class ThirdViewModel(finalScore: Int): ViewModel()  {


    init {
        Log.i("kik", "scoreViewModelCalled$finalScore")
    }
}