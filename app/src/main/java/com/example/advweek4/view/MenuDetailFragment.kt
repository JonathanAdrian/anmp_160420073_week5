package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4.R
import com.example.advweek4.viewmodel.DetailViewModel
import com.example.advweek4.viewmodel.MenuDetailViewModel
import com.squareup.picasso.Picasso

class MenuDetailFragment : Fragment() {
    private lateinit var viewModel: MenuDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(MenuDetailViewModel::class.java)

        // Observe the LiveData
        viewModel.menuLD.observe(viewLifecycleOwner, { menu ->
            val txtNamaDetail = view?.findViewById<TextView>(R.id.txtNamaDetail)
            val txtHargaDetail = view?.findViewById<TextView>(R.id.txtHargaDetail)
            val txtDeskripsiDetail = view?.findViewById<TextView>(R.id.txtDeskripsiDetail)
            val imgFotoDetail = view?.findViewById<ImageView>(R.id.imgFotoDetail)
//            val txtJumlahDetail = view?.findViewById<TextView>(R.id.txtJumlahDetail)
//            val btnAddDetail = view?.findViewById<Button>(R.id.btnAddDetail)
//            val btnTambahDetail = view?.findViewById<Button>(R.id.btnTambahDetail)
//            val btnKurangDetail = view?.findViewById<Button>(R.id.btnKurangDetail)

            txtNamaDetail?.text = menu.nama
            txtHargaDetail?.text = menu.harga.toString()
            txtDeskripsiDetail?.text = menu.deskripsi
            Picasso.get().load(menu.foto).into(imgFotoDetail)
        })
    }
}