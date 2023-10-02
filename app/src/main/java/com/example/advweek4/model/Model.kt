package com.example.advweek4.model

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val dob:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)

data class Movie(
    val id:Int?,
    val title:String?,
    val release_year:Int?,
    val genre:String?,
    val actors:List<String>?,
    val director:Director?
)

data class Director(
    val name:String?,
    val nationality:String?
)