package com.example.advweek4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advweek4.model.Movie
import com.example.advweek4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieViewModel(application: Application): AndroidViewModel(application) {
    val moviesLD = MutableLiveData<ArrayList<Movie>>()
    val TAG = "volleyTagMovie"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/anmp/movie.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<List<Movie>>(){}.type
                val result = Gson().fromJson<List<Movie>>(it, sType)
                moviesLD.value = result as ArrayList<Movie>?
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
}