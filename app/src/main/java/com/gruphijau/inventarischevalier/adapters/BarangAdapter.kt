package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.BarangData
import com.gruphijau.inventarischevalier.databinding.RvItemBarangBinding

class BarangAdapter(private val list: ArrayList<BarangData>) : RecyclerView.Adapter<BarangAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvItemBarangBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.images.setImageResource(currentItem.imgBrg)
        holder.binding.txtBarang.text = currentItem.namaBarang
        holder.binding.txtKet.text = currentItem.ket
        holder.binding.txtTanggal.text = currentItem.tanggal
        holder.binding.txtOleh.text = currentItem.oleh
    }

    override fun getItemCount(): Int {
        return list.size
    }
}