package com.gruphijau.inventarischevalier.fragments


import SupplierData
import SupplierViewModel
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.gruphijau.inventarischevalier.databinding.FragmentTambahSupplierBinding



class TambahSupplier : Fragment() {
    private lateinit var binding: FragmentTambahSupplierBinding
    private lateinit var viewModel: SupplierViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TambahSupplier", "onCreateView called")
        binding = FragmentTambahSupplierBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TambahSupplier", "onViewCreated called")

        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SupplierViewModel::class.java)

        binding.btnSimpan.setOnClickListener {
            val nama = binding.addName.text.toString().trim()
            val email = binding.addEmail.text.toString().trim()
            val alamat = binding.addAlamat.text.toString().trim()
            val telepon = binding.addTelepon.text.toString().trim()
            val id = binding.addId.text.toString().trim()

            if (TextUtils.isEmpty(nama) || TextUtils.isEmpty(email) || TextUtils.isEmpty(alamat) || TextUtils.isEmpty(telepon) || TextUtils.isEmpty(id)) {
                Snackbar.make(
                    binding.root,
                    "Data masih ada yang kosong!",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                viewModel.addSupplier(SupplierData(nama, email, telepon, alamat, id))
                getParentFragmentManager().popBackStack()
            }
        }

    }
}


