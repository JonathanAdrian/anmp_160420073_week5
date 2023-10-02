package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.advweek4.R
import com.example.advweek4.viewmodel.ListViewModel
import com.example.advweek4.viewmodel.MovieViewModel

class MovieListFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel
    private val movieListAdapter = MovieListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.refresh()
        val recViewMovie = view.findViewById<RecyclerView>(R.id.recViewMovie)
        recViewMovie.layoutManager = LinearLayoutManager(context)
        recViewMovie.adapter = movieListAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.moviesLD.observe(viewLifecycleOwner, Observer {
            movieListAdapter.updateMovieList(it)
        })
    }
}