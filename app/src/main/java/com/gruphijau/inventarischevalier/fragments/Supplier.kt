
import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.databinding.FragmentSupplierBinding
import com.gruphijau.inventarischevalier.fragments.DetailSupplier
import com.gruphijau.inventarischevalier.fragments.TambahSupplier

class Supplier : Fragment() {
    private lateinit var binding: FragmentSupplierBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SupplierAdapter
    private lateinit var viewModel: SupplierViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupplierBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SupplierViewModel::class.java)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycle_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        adapter = SupplierAdapter(viewModel.supplierList)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : SupplierAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val detailFragment = DetailSupplier()
                val bundle = Bundle()
                val supplier = viewModel.supplierList[position]
                bundle.putString("nama", supplier.nama)
                bundle.putString("email", supplier.email)
                bundle.putString("alamat", supplier.alamat)
                bundle.putString("telepon", supplier.telepon)
                bundle.putString("id", supplier.id)
                detailFragment.arguments = bundle

                getParentFragmentManager().beginTransaction()?.apply {
                    replace(R.id.container, detailFragment)
                    addToBackStack(null)
                    commit()
                }
            }
            override fun onDeleteClick(position: Int) {
                customDialog(position)
            }
        })

        binding.btnBack.setOnClickListener {

        }

        binding.addSupplier.setOnClickListener {
            getParentFragmentManager().beginTransaction()?.apply {
                replace(R.id.container, TambahSupplier(), TambahSupplier::class.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun customDialog(position: Int){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature((Window.FEATURE_NO_TITLE))
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_delete_supplier)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnYes: Button = dialog.findViewById(R.id.btn_yes)
        val btnNo: Button = dialog.findViewById(R.id.btn_no)

        btnYes.setOnClickListener {
            viewModel.deleteSupplier(position)
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}

