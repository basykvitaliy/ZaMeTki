package space.basyk.zametki.screens.purpose

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_purpose.view.*
import space.basyk.zametki.R
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.utils.showToast

class PurposeAdapter(private val viewModel: PurposeViewModel): RecyclerView.Adapter<PurposeAdapter.MyViewHolder>() {

    private var listPurpose = emptyList<PurposeModel>()
    private lateinit var deleteViewModel: PurposeViewModel

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titlePurpose: TextView = view.item_title_purpose
        val btnDel: ImageView = view.img_delete_purpose
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_purpose, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titlePurpose.text = listPurpose[position].titlePurpose
        holder.btnDel.setOnClickListener {
            showToast("Цель удалена")
            deleteViewModel.repository.deletePurpose(listPurpose[position])
        }
    }

    override fun getItemCount(): Int {
        return listPurpose.size
    }

    fun setList(list: List<PurposeModel>){
        listPurpose = list
        deleteViewModel = viewModel
        notifyDataSetChanged()
    }
}