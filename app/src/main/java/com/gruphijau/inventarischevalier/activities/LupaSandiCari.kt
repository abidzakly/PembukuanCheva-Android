package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityLupaSandiCariBinding

class LupaSandiCari : BaseActivity() {
    private lateinit var binding: ActivityLupaSandiCariBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLupaSandiCariBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnKirim.setOnClickListener{
            val credential = binding.edtEmailOrPhoneNumber.text.toString().trim()
            val intent = Intent(this, KodeOTP::class.java)
            intent.putExtra("credential", credential)
            startActivity(intent)
        }
    }
}