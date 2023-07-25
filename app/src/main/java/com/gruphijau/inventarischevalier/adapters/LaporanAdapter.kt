package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.LaporanData
import com.gruphijau.inventarischevalier.databinding.RvItemLaporanBinding

class LaporanAdapter(private val list: ArrayList<LaporanData>) : RecyclerView.Adapter<LaporanAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvItemLaporanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemLaporanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.imageLaporan.setImageResource(currentItem.image)
        holder.binding.txtUnit.text = currentItem.unit
    }

    override fun getItemCount(): Int {
        return list.size
    }
}