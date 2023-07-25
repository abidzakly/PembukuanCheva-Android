package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.adapters.LaporanAdapter
import com.gruphijau.inventarischevalier.data.LaporanData
import com.gruphijau.inventarischevalier.databinding.ActivityLaporanBinding

class Laporan : BaseActivity() {
    private lateinit var adapter: LaporanAdapter
    private lateinit var laporanList: ArrayList<LaporanData>
    private lateinit var binding: ActivityLaporanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.setHasFixedSize(true)

        laporanList = ArrayList()
        laporanList.add(LaporanData(R.drawable.pc_1, "18 unit Komputer build"))
        laporanList.add(LaporanData(R.drawable.printer_canon, "1 unit Printer Canon"))
        laporanList.add(LaporanData(R.drawable.tv, "1 unit TV LG"))
        adapter = LaporanAdapter(laporanList)
        binding.recycleView.adapter =  adapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }
    }
}