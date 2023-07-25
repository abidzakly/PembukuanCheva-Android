package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityItemDetailsBinding

class ItemDetails : BaseActivity() {
    var itemQuantity = 0
    var quantityAvailable = 0
    private lateinit var binding: ActivityItemDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemName = intent.getStringExtra("name") ?: ""
        val itemImage = intent.getIntExtra("image", 0)
        val itemStatus = intent.getStringExtra("status") ?: ""
        quantityAvailable = intent.getIntExtra("quantity", 0)
        binding.imageDetail.setImageResource(itemImage)
        binding.titleDetail.text = itemName
        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, ItemList::class.java)
            startActivity(prevPage)
            finish()
        }
        binding.editBtn.setOnClickListener {
            if (itemStatus == "Baik") {
                val intent = Intent(this, BorrowSuccess::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, BorrowFailed::class.java)
                startActivity(intent)
                finish()
            }
        }
//        binding.plusBtn.setOnClickListener {
//            binding.itemQuantity.text = addQuantity().toString()
//        }
//        binding.minusBtn.setOnClickListener {
//            binding.itemQuantity.text = decreaseQuantity().toString()
//        }
    }
    override fun onBackPressed() {
        val prevPage = Intent(this, ItemList::class.java)
        startActivity(prevPage)
        finish()
    }
    fun addQuantity(): Int {
        if (itemQuantity < quantityAvailable) {
        itemQuantity++
        }
        return itemQuantity
    }

    fun decreaseQuantity(): Int {
        if (itemQuantity > 1) {
            itemQuantity--
        }
        return itemQuantity
    }
}

