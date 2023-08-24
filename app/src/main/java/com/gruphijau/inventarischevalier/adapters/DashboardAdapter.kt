package com.gruphijau.inventarischevalier.adapters

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.activities.*
import com.gruphijau.inventarischevalier.data.DashboardData
import com.gruphijau.inventarischevalier.databinding.RvHomeDropdownBinding

class DashboardAdapter(private val dropdownList:ArrayList<DashboardData>, private val activity: Activity)
    : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    private var itemCount: Int = 0
    private var alert: AlertDialog? = null
    fun setItemCount(count: Int) {
        itemCount = count
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: RvHomeDropdownBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position: Int = adapterPosition
                val itemName = dropdownList[position].name
                if (itemName == "Daftar Barang") {
                    val nextPage = Intent(itemView.context, ItemList::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                } else if (itemName == "Pengembalian") {
                    val nextPage = Intent(itemView.context, Pengembalian::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                } else if (itemName == "Peminjaman") {
                    val nextPage = Intent(itemView.context, Peminjaman::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                } else if (itemName == "Data Pengguna") {
                    val nextPage = Intent(itemView.context, UserData::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                }  else if (itemName == "Laporan") {
                    val nextPage = Intent(itemView.context, Laporan::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                } else if (itemName == "Barang Masuk") {
                    val nextPage = Intent(itemView.context, BarangMasuk::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                } else if (itemName == "Supplier") {
                    val nextPage = Intent(itemView.context, SupplierFragment::class.java)
                    itemView.context.startActivity(nextPage)
                    activity.finish()
                } else {
                    alertCreate()
                }

            }
        }
        fun alertCreate() {
            alert = AlertDialog.Builder(itemView.context)
                .setTitle("Pemberitahuan")
                .setMessage("Maaf, UI belum ada.")
                .setPositiveButton("Ok", null)
                .create()

            alert?.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvHomeDropdownBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dropdownList[position]
        holder.binding.content.text = item.name
    }

    override fun getItemCount(): Int {
        return itemCount
    }
}