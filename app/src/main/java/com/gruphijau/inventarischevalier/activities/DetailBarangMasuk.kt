package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.databinding.ActivityDetailBarangMasukBinding


class DetailBarangMasuk : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBarangMasukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_barang_masuk)
        binding = ActivityDetailBarangMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images: ImageView = binding.images
        val barang: TextView = binding.tvBarang
        val jumlah: TextView = binding.tvJumlah
        val tanggal: TextView = binding.tvTanggal

        val image = intent.getIntExtra("IMAGES",0)
        val namaBrg = intent.getStringExtra("BARANG")
        val jumlahBrg = intent.getStringExtra("JUMLAH")
        val tanggalMsk = intent.getStringExtra("TANGGAL")

        images.setImageResource(image)
        barang.text = namaBrg
        jumlah.text = jumlahBrg
        tanggal.text = tanggalMsk

        binding.btnClose.setOnClickListener {
            val intent = Intent(this, BarangMasuk::class.java)
            startActivity(intent)
        }
    }
}