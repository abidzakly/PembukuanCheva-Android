package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.HistoryPinjamData
import com.gruphijau.inventarischevalier.databinding.RvPeminjamanBinding

class PeminjamAdapter(private val itemsList:ArrayList<HistoryPinjamData>)
    : RecyclerView.Adapter<PeminjamAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvPeminjamanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvPeminjamanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.binding.image.setImageResource(item.image)
        holder.binding.namaPeminjam.text = item.name
        holder.binding.description.text = item.descriptionPinjam
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}