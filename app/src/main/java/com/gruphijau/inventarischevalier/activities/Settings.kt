package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityPengaturanBinding

class Settings : BaseActivity() {
    private lateinit var binding: ActivityPengaturanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPengaturanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        binding.userName.text = username
        binding.email.text = "${username}@gmail.com"
        val email = binding.email.text

        binding.containerFill1.setOnClickListener {
            val nextPage = Intent(this, EditProfile::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(nextPage)
        }

        binding.containerFill2.setOnClickListener {
            val nextPage = Intent(this, RiwayatBarang::class.java)
            startActivity(nextPage)
        }

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }
        binding.containerLogout.setOnClickListener{
            val prevPage = Intent(this, MainActivity::class.java)
            startActivity(prevPage)
            finish()
        }
    }
}