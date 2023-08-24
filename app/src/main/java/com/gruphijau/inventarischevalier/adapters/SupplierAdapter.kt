import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.databinding.RvItemSupplierBinding

class SupplierAdapter(val list: ArrayList<SupplierData>) : RecyclerView.Adapter<SupplierAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
        fun onDeleteClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    inner class ViewHolder(val binding: RvItemSupplierBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemSupplierBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.tvNama.text = currentItem.nama

        holder.binding.delete.setOnClickListener {
            mListener.onDeleteClick(position)
        }

        holder.itemView.setOnClickListener {
            mListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
