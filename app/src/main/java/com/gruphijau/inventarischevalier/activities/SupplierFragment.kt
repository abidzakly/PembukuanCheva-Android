package com.gruphijau.inventarischevalier.activities

import Supplier
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gruphijau.inventarischevalier.R

class SupplierFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_fragment)

        val fragment = supportFragmentManager.findFragmentByTag(Supplier::class.simpleName)

        if(fragment !is Supplier){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, Supplier(), Supplier::class.simpleName)
                .commit()
        }
    }
}