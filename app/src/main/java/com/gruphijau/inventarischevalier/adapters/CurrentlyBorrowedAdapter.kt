package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.CurrentlyBorrowedData
import com.gruphijau.inventarischevalier.databinding.RvCurrentlyBorrowedBinding

class CurrentlyBorrowedAdapter(private val riwayatList:ArrayList<CurrentlyBorrowedData>)
    : RecyclerView.Adapter<CurrentlyBorrowedAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvCurrentlyBorrowedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvCurrentlyBorrowedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = riwayatList[position]
        holder.binding.images.setImageResource(item.image)
        holder.binding.txtBarang.text = item.title
        holder.binding.unit.text = "${item.unit} unit ${item.title} ${item.status}"
        holder.binding.txtTanggal.text = item.date
        holder.binding.borrowerName.text = item.borrowerName
    }

    override fun getItemCount(): Int {
        return riwayatList.size
    }
}