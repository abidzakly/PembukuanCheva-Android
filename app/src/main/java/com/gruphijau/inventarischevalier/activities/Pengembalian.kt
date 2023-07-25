package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.adapters.CurrentlyBorrowedAdapter
import com.gruphijau.inventarischevalier.data.CurrentlyBorrowedData
import com.gruphijau.inventarischevalier.databinding.ActivityPengembalianBinding

class Pengembalian : BaseActivity() {
    private lateinit var adapter: CurrentlyBorrowedAdapter
    private lateinit var list: ArrayList<CurrentlyBorrowedData>
    private lateinit var binding: ActivityPengembalianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPengembalianBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.setHasFixedSize(true)

        list = ArrayList()
        list.add(CurrentlyBorrowedData(R.drawable.terminal_listrik, "Terminal", 2, "masuk", "31 Mei 2023", "Dian"))
        list.add(CurrentlyBorrowedData(R.drawable.vr, "Oculus Dev Kit II", 2, "dikembalikan", "1 Juni 2023", "Dian"))
        adapter = CurrentlyBorrowedAdapter(list)
        binding.recycleView.adapter =  adapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }


    }
}