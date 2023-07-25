package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.HistoryPinjamData
import com.gruphijau.inventarischevalier.databinding.RvPengembalianBinding

class PengembalianAdapter(private val itemsList: ArrayList<HistoryPinjamData>)
    : RecyclerView.Adapter<PengembalianAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvPengembalianBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvPengembalianBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.binding.image.setImageResource(item.image)
        holder.binding.namaPeminjam.text = item.name
        holder.binding.description.text = item.descriptionKembali
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}