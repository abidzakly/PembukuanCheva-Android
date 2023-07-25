package com.gruphijau.inventarischevalier.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityChangePasswordBinding

class ChangePassword : BaseActivity() {
    private lateinit var binding : ActivityChangePasswordBinding
    private var alert: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIkonBack.setOnClickListener{
            val intent = Intent(this, KodeOTP::class.java)
            startActivity(intent)
        }
        val sandiBaru = binding.edtPasswordBaru.text.toString()
        val verifSandiBaru = binding.edtPasswordBaru.text.toString()

        if (sandiBaru != verifSandiBaru) {
            alertCreate()
            return
        }
        binding.btnKirimSandiBaru.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("passwordBaru", sandiBaru)
            startActivity(intent)
        }
    }

    fun alertCreate() {
        alert = AlertDialog.Builder(this)
            .setTitle("Pemberitahuan")
            .setMessage("Password anda tidak sama!")
            .setPositiveButton("Ok", null)
            .setNegativeButton("Ok", null)
            .create()

        alert?.show()
    }
}