package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.adapters.BarangAdapter
import com.gruphijau.inventarischevalier.data.BarangData
import com.gruphijau.inventarischevalier.databinding.ActivityBarangMasukBinding

class BarangMasuk : AppCompatActivity() {
    private lateinit var adapter: BarangAdapter
    private lateinit var list: ArrayList<BarangData>
    private lateinit var binding: ActivityBarangMasukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang_masuk)

        binding = ActivityBarangMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.setHasFixedSize(true)

        list = ArrayList()
        list.add(BarangData(R.drawable.terminal, "Terminal", "1", "30 Mei 2023"))
        list.add(BarangData(R.drawable.terminal, "Terminal", "1", "31 Mei 2023"))
        list.add(BarangData(R.drawable.oculus, "Oculus Dev Kit II", "1", "1 Juni 2023"))
        adapter = BarangAdapter(list)
        binding.recycleView.adapter =  adapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)

        adapter.setOnClickListener(object : BarangAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val item = list[position]
                val intent = Intent(this@BarangMasuk, DetailBarangMasuk::class.java)
                intent.putExtra("IMAGES", item.imgBarang)
                intent.putExtra("BARANG", item.namaBarang)
                intent.putExtra("JUMLAH", item.jumlah)
                intent.putExtra("TANGGAL", item.tanggal)
                startActivity(intent)
            }
        })

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}