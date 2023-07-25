package com.gruphijau.inventarischevalier.activities
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.gruphijau.inventarischevalier.adapters.ItemsAdapter
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.data.ItemsData
import com.gruphijau.inventarischevalier.databinding.ActivityListItemBinding

class ItemList : BaseActivity() {
    private lateinit var adapter: ItemsAdapter
    private lateinit var list: ArrayList<ItemsData>
    private lateinit var binding: ActivityListItemBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.setHasFixedSize(true)

        list = ArrayList()
        list.add(ItemsData(1, R.drawable.tv, "TV LG", 1, "Rusak"))
        list.add(ItemsData(2, R.drawable.printer_canon, "Printer Canon", 1, "Rusak"))
        list.add(ItemsData(3, R.drawable.printer_hp, "Printer HP", 1, "Rusak"))
        list.add(ItemsData(4, R.drawable.pc_1, "Komputer Build UP", 18, "Rusak"))
        list.add(ItemsData(5, R.drawable.pc_2, "Komputer Rakitan", 1, "Rusak"))
        list.add(ItemsData(6, R.drawable.dispenser, "Dispenser", 1, "Baik"))
        list.add(ItemsData(7, R.drawable.terminal_listrik, "Terminal", 23, "Baik"))
        list.add(ItemsData(8, R.drawable.vr, "Oculus Dev Kit II", 1, "Baik"))
        list.add(ItemsData(9, R.drawable.vr_box, "VR Box", 1, "Baik"))
        list.add(ItemsData(10, R.drawable.xbox_360, "XBOX 360 Kinect", 1, "Baik"))
        list.add(ItemsData(11, R.drawable.fingerspot, "Fingerspot", 1, "Baik"))
        list.add(ItemsData(12, R.drawable.vr_remax, "VR Remax", 1, "Baik"))
        list.add(ItemsData(13, R.drawable.bobo_vr, "BoboVR", 1, "Baik"))
        list.add(ItemsData(14, R.drawable.vr_shinecon, "VR Shinecon", 1, "Baik"))
        list.add(ItemsData(15, R.drawable.leap_motion, "Leap Motion", 1, "Baik"))
        list.add(ItemsData(16, R.drawable.gantungan, "Gantungan", 1, "Baik"))

        adapter = ItemsAdapter(list, this)
        binding.rv.adapter =  adapter
        binding.rv.layoutManager = GridLayoutManager(this, 2)

        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }
    }

    override fun onBackPressed() {
        val prevPage = Intent(this, Dashboard::class.java)
        startActivity(prevPage)
        finish()
    }
}
