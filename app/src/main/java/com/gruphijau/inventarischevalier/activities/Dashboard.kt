package com.gruphijau.inventarischevalier.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.adapters.DashboardAdapter
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.data.DashboardData
import com.gruphijau.inventarischevalier.databinding.ActivityDashboardBinding

class Dashboard : BaseActivity() {
    var counterBarang: Int = 0
    var counterLaporan: Int = 0
    private var alert: AlertDialog? = null
    private lateinit var adapterBarang: DashboardAdapter
    private lateinit var adapterLaporan: DashboardAdapter
    private lateinit var listBarang: ArrayList<DashboardData>
    private lateinit var listLaporan: ArrayList<DashboardData>
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

        if (username != "") {
        binding.welcomeText.text = "Hi, ${username}"
        } else {
        binding.welcomeText.text = "Hi, User"
        }

        binding.rvBarang.setHasFixedSize(true)
        binding.rvLaporan.setHasFixedSize(true)

        listBarang = ArrayList()
        listLaporan = ArrayList()

        listBarang.add(DashboardData(1, "Daftar Barang"))
        listBarang.add(DashboardData(2, "Tambah Barang"))


        listLaporan.add(DashboardData(1, "Peminjaman"))
        listLaporan.add(DashboardData(2, "Data Pengguna"))
        listLaporan.add(DashboardData(3, "Laporan"))
        listLaporan.add(DashboardData(4, "Barang Masuk"))
        listLaporan.add(DashboardData(5, "Supplier"))


        adapterBarang = DashboardAdapter(listBarang, this)
        binding.rvBarang.adapter = adapterBarang
        binding.rvBarang.layoutManager = LinearLayoutManager(this)

        adapterLaporan = DashboardAdapter(listLaporan, this)
        binding.rvLaporan.adapter = adapterLaporan
        binding.rvLaporan.layoutManager = LinearLayoutManager(this)

        binding.iconUser.setOnClickListener {
            val nextPage = Intent(this, EditProfile::class.java)
            intent.putExtra("username", username)
            startActivity(nextPage)
        }

        binding.dropdownBarang.setOnClickListener {
            if (counterBarang == 1) {
                val newCount = 0
            adapterBarang.setItemCount(newCount)
            binding.dropdownBarang.setImageResource(R.drawable.icon_dropdownn)
            binding.barangLine.setImageDrawable(null)
                counterBarang--
            } else if (counterBarang == 0){
            val newCount = 2
            adapterBarang.setItemCount(newCount)
            binding.dropdownBarang.setImageResource(R.drawable.icon_dropdown_after)
            binding.barangLine.setImageResource(R.drawable.dropdown_line)
                counterBarang++
            }
        }

        binding.dropdownLaporan.setOnClickListener {
            if (counterLaporan == 1) {
                val newCount = 0
            adapterLaporan.setItemCount(newCount)
            binding.dropdownLaporan.setImageResource(R.drawable.icon_dropdownn)
                binding.laporanLine.setImageDrawable(null)
                counterLaporan--
            } else if (counterLaporan == 0){
            val newCount = 4
            adapterLaporan.setItemCount(newCount)
            binding.dropdownLaporan.setImageResource(R.drawable.icon_dropdown_after)
            binding.laporanLine.setImageResource(R.drawable.dropdown_line)
                counterLaporan++
            }
        }
    }

    override fun onBackPressed() {
        alertCreate()
    }

    fun alertCreate() {
        alert = AlertDialog.Builder(this)
            .setTitle("Pemberitahuan")
            .setMessage("Anda yakin ingin keluar?")
            .setPositiveButton("Ya") { _, _ ->
                startActivity(Intent(this, MainActivity::class.java))
            }
            .setNegativeButton("Tidak", null)

        .show()
    }
}