package com.example.advweek4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _tableNumber = MutableLiveData<String>()
    val tableNumber: LiveData<String> = _tableNumber

    fun setTableNumber(number: String) {
        _tableNumber.value = number
    }
}