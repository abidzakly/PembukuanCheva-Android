package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityKodeOtpBinding

class KodeOTP : BaseActivity() {
    private lateinit var binding: ActivityKodeOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKodeOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIconBackFromOTP.setOnClickListener{
            val intent = Intent(this, LupaSandiCari::class.java)
            startActivity(intent)
        }

        binding.btnKirim.setOnClickListener{
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
    }
}