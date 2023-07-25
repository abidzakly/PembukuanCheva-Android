package com.gruphijau.inventarischevalier.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.data.NotifData
import com.gruphijau.inventarischevalier.databinding.RvPemberitahuanBinding

class NotifAdapter(private val notifList:ArrayList<NotifData>)
    : RecyclerView.Adapter<NotifAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvPemberitahuanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvPemberitahuanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = notifList[position]
        holder.binding.pemberitahuanContent.text = item.name
    }

    override fun getItemCount(): Int {
        return notifList.size
    }
}