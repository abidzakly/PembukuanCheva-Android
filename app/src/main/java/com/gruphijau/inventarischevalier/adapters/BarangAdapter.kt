package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.BarangData
import com.gruphijau.inventarischevalier.databinding.RvItemBarangBinding

class BarangAdapter(private val list: ArrayList<BarangData>) : RecyclerView.Adapter<BarangAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    inner class ViewHolder(val binding: RvItemBarangBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.images.setImageResource(currentItem.imgBarang)
        holder.binding.txtBarang.text = currentItem.namaBarang
        holder.binding.txtJumlah.text = currentItem.jumlah
        holder.binding.txtNamaunit.text = currentItem.namaBarang
        holder.binding.txtTanggal.text = currentItem.tanggal

        holder.itemView.setOnClickListener {
            mListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}