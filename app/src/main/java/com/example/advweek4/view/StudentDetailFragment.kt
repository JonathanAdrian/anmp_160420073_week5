package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4.R
import com.example.advweek4.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        // Observe the LiveData
        viewModel.studentLD.observe(viewLifecycleOwner, { student ->
            val editName = view?.findViewById<EditText>(R.id.editName)
            val editBod = view?.findViewById<EditText>(R.id.editBod)
            val editPhone = view?.findViewById<EditText>(R.id.editPhone)
            val editId = view?.findViewById<EditText>(R.id.editId)
            editName?.setText(student.name)
            editBod?.setText(student.dob)
            editPhone?.setText(student.phone)
            editId?.setText(student.id)
        })
        viewModel.fetch()
    }
}