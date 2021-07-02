package com.development.hybrid.schedule.views.main.ui.electronic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElectronicViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is electronic Fragment"
    }
    val text: LiveData<String> = _text
}