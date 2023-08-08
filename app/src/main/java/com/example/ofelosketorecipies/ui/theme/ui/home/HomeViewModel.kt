package com.example.reciperadar.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to the Recipe Radar cook book\n"+
                "Here, we show you all the amazing different recipes your heart desires through easy to follow processes"
    }
    val text: LiveData<String> = _text
}