package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.databinding.ActivitySplashScreen2Binding

class SplashLogo : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1750) // 3000 is the delayed time in milliseconds.
    }
}