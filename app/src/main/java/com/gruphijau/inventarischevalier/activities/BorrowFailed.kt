package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityBorrowFailedBinding

class BorrowFailed : BaseActivity() {
    private lateinit var binding: ActivityBorrowFailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBorrowFailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, ItemList::class.java)
            startActivity(prevPage)
            finish()
        }
    }
    override fun onBackPressed() {
        val prevPage = Intent(this, ItemList::class.java)
        startActivity(prevPage)
        finish()
    }
}