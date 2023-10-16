package com.example.advweek4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advweek4.model.Menu

class MenuDetailViewModel(application: Application): AndroidViewModel(application) {
    val menuLD = MutableLiveData<Menu>()

    fun setSelectedMenu(menu: Menu) {
        menuLD.value = menu
    }
}