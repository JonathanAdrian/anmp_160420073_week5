package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.viewmodel.MenuDetailViewModel
import com.example.advweek4.viewmodel.MenuViewModel

class MenuFragment : Fragment() {
    private lateinit var viewModel: MenuViewModel
    private lateinit var menuDetailViewModel: MenuDetailViewModel
    private lateinit var menuAdapter : MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuDetailViewModel = ViewModelProvider(requireActivity()).get(MenuDetailViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menuAdapter = MenuAdapter(arrayListOf(), menuDetailViewModel)
        viewModel.refresh()
        val recViewMenu = view.findViewById<RecyclerView>(R.id.recViewMenu)
        recViewMenu.layoutManager = LinearLayoutManager(context)
        recViewMenu.adapter = menuAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.menusLD.observe(viewLifecycleOwner, Observer {
            menuAdapter.updateMenu(it)
        })
    }
}