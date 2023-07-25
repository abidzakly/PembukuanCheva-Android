package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityEditBarangBinding

class EditBarang : BaseActivity() {
    private lateinit var binding: ActivityEditBarangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveInfoBarang.setOnClickListener {
            val nama_barang = binding.edtNamaBarang.text.toString()
            val kondisi_barang = binding.edtKondisiBarang.text.toString()
            val jumlah_barang = binding.edtKondisiBarang.text.toString()
            val deskripsi_barang = binding.edtKondisiBarang.text.toString()

            // Isi data barang
            if (nama_barang.isEmpty()) {
                binding.edtNamaBarang.error = "Nama barang harus diisi!"
            } else if (kondisi_barang.isEmpty()) {
                binding.edtKondisiBarang.error = "Kondisi barang harus diisi!"
            } else if (jumlah_barang.isEmpty()) {
                binding.edtJumlahBarang2.error = "Jumlah barang harus diisi!"
            } else {
                if (deskripsi_barang.isEmpty()) {
                    binding.edtDeskripsiBarang.error = "Deskripsi barang harus diisi!"
                } else if (deskripsi_barang.length < 10) {
                    binding.edtDeskripsiBarang.error = "Deskripsi barang harus memiliki minimal 10 karakter!"
                } else {
                    val intent = Intent(this, DetailBarang::class.java)
                    intent.putExtra("Nama Barang", nama_barang)
                    startActivity(intent)
                    finish()
                }
            }
            binding.buttonBack.setOnClickListener {
                val prevPage = Intent(this, ItemList::class.java)
                startActivity(prevPage)
                finish()
            }
        }
    }}