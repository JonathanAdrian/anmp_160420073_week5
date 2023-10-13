package com.example.advweek4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advweek4.model.Menu

class MenuDetailViewModel(application: Application): AndroidViewModel(application) {
    val menuLD = MutableLiveData<Menu>()

//    fun fetch() {
//        val menu1 = Menu(1,"https://www.natural-poultry.com/wp-content/uploads/2021/04/Ayam-rica-rica-1200x900.jpg","Ayam Rica-Rica",
//            "Makanan", "Ayam Rica-Rica adalah hidangan khas dari Sulawesi, Indonesia. Ayam dimasak dengan saus pedas berbahan dasar cabai" +
//                    " dan rempah-rempah. Rasanya sangat pedas dan lezat. Disajikan dengan nasi.",60000)
//        menuLD.value = menu1
//    }

    fun setSelectedMenu(menu: Menu) {
        menuLD.value = menu
    }
}