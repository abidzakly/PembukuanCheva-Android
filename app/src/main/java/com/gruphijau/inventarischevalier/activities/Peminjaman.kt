package com.gruphijau.inventarischevalier.activities
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.adapters.PeminjamAdapter
import com.gruphijau.inventarischevalier.adapters.PengembalianAdapter
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.data.HistoryPinjamData
import com.gruphijau.inventarischevalier.databinding.ActivityPeminjamanBinding

class Peminjaman : BaseActivity() {
    private lateinit var adapterPeminjam: PeminjamAdapter
    private lateinit var adapterPengembalian: PengembalianAdapter
    private lateinit var listHistoryPinjamData: ArrayList<HistoryPinjamData>
    private lateinit var listPengembalian: ArrayList<HistoryPinjamData>
    private lateinit var binding: ActivityPeminjamanBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPeminjamanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPeminjaman.setHasFixedSize(true)
        binding.rvPengembalian.setHasFixedSize(true)

        listHistoryPinjamData = ArrayList()
        listPengembalian = ArrayList()
        listHistoryPinjamData.add(HistoryPinjamData(1,
            R.drawable.terminal_listrik, "Uzumaki Agus", "2 Unit terminal pada 10-01-2023", ""))
        listHistoryPinjamData.add(HistoryPinjamData(2,
            R.drawable.dispenser, "Bagus Bagas", "1 Unit Dispenser pada 18-01-2023", ""))
        listHistoryPinjamData.add(HistoryPinjamData(3,
            R.drawable.printer_canon, "Cheva Chevi", "1 Unit Printer Canon pada 19-01-2023", ""))
        listHistoryPinjamData.add(HistoryPinjamData(4,
            R.drawable.vr_shinecon, "Liar Lier", "1 Unit VR Shinecon pada 20-01-2023", ""))
        listHistoryPinjamData.add(HistoryPinjamData(5,
            R.drawable.leap_motion, "Komang Komeng", "1 Unit Leap Motion pada 21-01-2023", ""))
        listHistoryPinjamData.add(HistoryPinjamData(6,
            R.drawable.tv, "Tobi Tobu", "1 Unit TV pada 22-01-2023", ""))

        listPengembalian.add(HistoryPinjamData(1, R.drawable.terminal_listrik, "Uzumaki Agus", "", "2 Unit terminal pada 13-01-2023 "))
        listPengembalian.add(HistoryPinjamData(2, R.drawable.dispenser, "Bagus Bagas", "", "1 Unit Dispenser pada 20-01-2023"))
        listPengembalian.add(HistoryPinjamData(3, R.drawable.printer_canon, "Cheva Chevi", "", "1 Unit Printer Canon pada 21-01-2023"))
        listPengembalian.add(HistoryPinjamData(4, R.drawable.vr_shinecon, "Liar Lier", "", "1 Unit VR Shinecon pada 22-01-2023"))
        listPengembalian.add(HistoryPinjamData(5, R.drawable.leap_motion, "Komang Komeng", "", "1 Unit Leap Motion pada 23-01-2023"))
        listPengembalian.add(HistoryPinjamData(6, R.drawable.tv, "Tobi Tobu", "", "1 Unit TV pada 24-01-2023"))


        adapterPeminjam = PeminjamAdapter(listHistoryPinjamData)
        binding.rvPeminjaman.adapter =  adapterPeminjam
        binding.rvPeminjaman.layoutManager = LinearLayoutManager(this)

        adapterPengembalian = PengembalianAdapter(listPengembalian)
        binding.rvPengembalian.adapter =  adapterPengembalian
        binding.rvPengembalian.layoutManager = LinearLayoutManager(this)

        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }
    }

    override fun onBackPressed() {
        val prevPage = Intent(this, Dashboard::class.java)
        startActivity(prevPage)
        finish()
    }
}
