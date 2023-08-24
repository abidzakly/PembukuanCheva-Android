import androidx.lifecycle.ViewModel

class SupplierViewModel : ViewModel() {
    val supplierList: ArrayList<SupplierData> = ArrayList()

    fun addSupplier(supplier: SupplierData) {
        supplierList.add(supplier)
    }

    fun deleteSupplier(position : Int) {
        supplierList.removeAt(position)
    }
}
