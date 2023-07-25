package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.HistoryItemsData
import com.gruphijau.inventarischevalier.databinding.RvRiwayatBarangBinding

class RiwayatBarangAdapter(private val riwayatList:ArrayList<HistoryItemsData>)
    : RecyclerView.Adapter<RiwayatBarangAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvRiwayatBarangBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvRiwayatBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = riwayatList[position]
        holder.binding.imageRiwayatPinjam.setImageResource(item.image)
        holder.binding.peminjamanTitle.text = item.title
        holder.binding.tanggalPinjam.text = item.description
    }

    override fun getItemCount(): Int {
        return riwayatList.size
    }
}