package com.gruphijau.inventarischevalier.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.activities.ItemDetails
import com.gruphijau.inventarischevalier.data.ItemsData
import com.gruphijau.inventarischevalier.databinding.RvItemsBinding

class ItemsAdapter(private val itemsList:ArrayList<ItemsData>, private val activity: Activity)
    : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position: Int = adapterPosition
                val itemName = itemsList[position].name
                val itemImage = itemsList[position].image
                val itemStatus = itemsList[position].status
                val itemQuantity = itemsList[position].quantity

                val intent = Intent(itemView.context, ItemDetails::class.java)
                intent.putExtra("name", itemName)
                intent.putExtra("image", itemImage)
                intent.putExtra("status", itemStatus)
                intent.putExtra("quantity", itemQuantity)
                itemView.context.startActivity(intent)

                activity.finish()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.binding.itemImage.setImageResource(item.image)
        holder.binding.itemTitle.text = item.name
        holder.binding.itemQuantity.text = "${item.quantity} Unit"
        holder.binding.itemStatus.text = item.status
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}