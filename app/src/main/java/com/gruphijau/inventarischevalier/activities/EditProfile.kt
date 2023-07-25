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

        binding.saveProfileButton.setOnClickListener {
            val nama_admin = binding.adminnamePlacholder.text.toString()
            val email_admin = binding.emailPlacholder.text.toString()
            val no_telp_admin = binding.noTelpPlacholder.text.toString()

            // Isi data barang
            if (nama_admin.isEmpty()) {
                binding.adminnamePlacholder.error = "Nama lengkap harus diisi!"
            } else if (email_admin.isEmpty()) {
                binding.emailPlacholder.error = "Email harus diisi!"
            } else {
                if (no_telp_admin.isEmpty()) {
                    binding.noTelpPlacholder.error = "Nomor telepon harus diisi!"
                } else {
                    val intent = Intent(this, DetailBarang::class.java)
                    intent.putExtra("Nama lengkap", nama_admin)
                    startActivity(intent)
                    finish()
                }
            }
        }

//        val username = intent.getStringExtra("username")
//        val email = intent.getStringExtra("email")
//        binding.fullnamePlacholder.text = username
//        binding.emailPlacholder.text = email

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }
    }
}