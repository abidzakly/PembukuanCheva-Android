package com.gruphijau.inventarischevalier.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gruphijau.inventarischevalier.databinding.FragmentDetailSupplierBinding

class DetailSupplier : Fragment() {
    private var _binding : FragmentDetailSupplierBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailSupplierBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama: TextView = binding.tvNama
        val email: TextView = binding.tvEmail
        val alamat: TextView = binding.tvAlamat
        val telepon: TextView = binding.tvTelepon
        val id: TextView = binding.tvId

        val namaSupplier = arguments?.getString("nama")
        val emailSupplier = arguments?.getString("email")
        val alamatSupplier = arguments?.getString("alamat")
        val teleponSupplier = arguments?.getString("telepon")
        val idSupplier = arguments?.getString("id")

        nama.text = namaSupplier
        email.text = emailSupplier
        alamat.text = alamatSupplier
        telepon.text = teleponSupplier
        id.text = idSupplier

        binding.btnClose.setOnClickListener {
            getParentFragmentManager().popBackStack()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}