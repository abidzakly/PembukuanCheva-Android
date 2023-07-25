package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.adapters.BarangAdapter
import com.gruphijau.inventarischevalier.data.BarangData
import com.gruphijau.inventarischevalier.databinding.ActivityBarangMasukBinding

class BarangMasuk : BaseActivity() {
    private lateinit var adapter: BarangAdapter
    private lateinit var list: ArrayList<BarangData>
    private lateinit var binding: ActivityBarangMasukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarangMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.setHasFixedSize(true)

        list = ArrayList()
        list.add(BarangData(R.drawable.terminal_listrik, "Terminal", "1 unit terminal masuk", "30 Mei 2023", "Dian"))
        list.add(BarangData(R.drawable.terminal_listrik, "Terminal", "1 unit terminal masuk", "31 Mei 2023", "Dian"))
        list.add(BarangData(R.drawable.vr, "Oculus Dev Kit II", "1 unit Oculus Dev Kit II dikembalikan", "1 Juni 2023", "Dian"))
        adapter = BarangAdapter(list)
        binding.recycleView.adapter =  adapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }
    }
}