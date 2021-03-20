package space.basyk.zametki.screens.shops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add_shop.view.*
import kotlinx.android.synthetic.main.item_shops.view.*
import space.basyk.zametki.R
import space.basyk.zametki.models.ShopModel
import space.basyk.zametki.utils.showToast

class ShopsAdapter(private val viewModel: ShopsViewModel): RecyclerView.Adapter<ShopsAdapter.MyViewHolder>() {

    private var listShops = emptyList<ShopModel>()
    private lateinit var deleteViewModel: ShopsViewModel


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleShop: TextView = view.item_title_shop
        val btnDel: ImageView = view.img_delete_shop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shops, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleShop.text = listShops[position].shopTitle
        holder.btnDel.setOnClickListener {
            showToast("Покупка удалена")
            deleteViewModel.deleteShop(listShops[position])
        }
    }

    override fun getItemCount(): Int {
        return listShops.size
    }

    fun setList(list: List<ShopModel>){
        listShops = list
        deleteViewModel = viewModel
        notifyDataSetChanged()
    }
}