package space.basyk.zametki.screens.plansofday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_purpose.view.*
import kotlinx.android.synthetic.main.item_shops.view.*
import space.basyk.zametki.R
import space.basyk.zametki.models.PlanOfDayModel

class DayAdapter: RecyclerView.Adapter<DayAdapter.MyViewHolder>() {

    private var listDay = emptyList<PlanOfDayModel>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleOne: TextView = view.item_title_purpose
        val titleTwo: TextView = view.item_title_shop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plan_of_day, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleOne.text = listDay[position].titleOne
        holder.titleTwo.text = listDay[position].titleTwo
    }

    override fun getItemCount(): Int {
        return listDay.size
    }

    fun setList(list: List<PlanOfDayModel>){
        listDay = list
        notifyDataSetChanged()
    }
}