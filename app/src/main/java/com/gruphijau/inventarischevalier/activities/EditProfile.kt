package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityEditProfilBinding

class EditProfile : BaseActivity() {
    private lateinit var binding: ActivityEditProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        binding.fullnamePlacholder.text = username
        binding.emailPlacholder.text = email

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, Settings::class.java)
            startActivity(prevPage)
            finish()
        }
    }
}