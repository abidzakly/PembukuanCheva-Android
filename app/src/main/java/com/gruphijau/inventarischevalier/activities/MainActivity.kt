package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBuatAkun.setOnClickListener{
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        binding.tvLupaSandi.setOnClickListener{
            val intent = Intent(this, LupaSandiCari::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            // Verifikasi Username
            if (username.isEmpty()) {
                binding.edtUsername.error = "Email atau Username harus diisi!"
            } else {
                if (password.isEmpty()) {
                    binding.edtPassword.error = "Password harus diisi!"
                } else if (password.length < 6) {
                    binding.edtPassword.error = "Password harus memiliki minimal 6 karakter!"
                } else {
                    val intent = Intent(this, Dashboard::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}