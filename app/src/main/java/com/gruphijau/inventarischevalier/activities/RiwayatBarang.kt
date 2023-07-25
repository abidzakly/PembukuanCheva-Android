package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.adapters.RiwayatBarangAdapter
import com.gruphijau.inventarischevalier.data.HistoryItemsData
import com.gruphijau.inventarischevalier.databinding.ActivityRiwayatBinding

class RiwayatBarang : BaseActivity() {
    private lateinit var adapter: RiwayatBarangAdapter
    private lateinit var list: ArrayList<HistoryItemsData>
    private lateinit var binding: ActivityRiwayatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiwayatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvRiwayat.setHasFixedSize(true)

        list = ArrayList()
        list.add(HistoryItemsData(1, R.drawable.icon_peminjaman, "Peminjaman XBOX", "Meminjam XBOX pada tanggal 5 Mei 2023"))
        list.add(HistoryItemsData(2, R.drawable.icon_barang_masuk, "Pengembalian VR", "Mengembalikan VR pada tanggal 7 Mei 2023"))

        adapter = RiwayatBarangAdapter(list)
        binding.rvRiwayat.adapter = adapter
        binding.rvRiwayat.layoutManager = LinearLayoutManager(this)

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, Settings::class.java)
            startActivity(prevPage)
            finish()
        }

    }
}