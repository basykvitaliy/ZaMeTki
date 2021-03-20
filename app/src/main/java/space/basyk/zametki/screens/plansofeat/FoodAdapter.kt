package space.basyk.zametki.screens.plansofeat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add_of_food.view.*
import kotlinx.android.synthetic.main.item_plan_of_food.view.*
import space.basyk.zametki.R
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.utils.showToast


class FoodAdapter(private val viewModel: PlanOfEatViewModel): RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    private var listFood = emptyList<PlanOfFoodModel>()
    private lateinit var delViewModel: PlanOfEatViewModel

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val date: TextView = view.item_tv_date
        val zavtrak: TextView = view.item_food_zavtrak
        val obed: TextView = view.item_food_obed
        val uzin: TextView = view.item_food_uzin
        val btnDel: ImageView = view.img_delete_food
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plan_of_food, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.date.text = listFood[position].date
        holder.zavtrak.text = listFood[position].zavtrakFood
        holder.obed.text = listFood[position].obedFood
        holder.uzin.text = listFood[position].uzinFood
        holder.btnDel.setOnClickListener {
            showToast("Удалено расписания на день")
            delViewModel.deleteFoods(listFood[position])
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    fun setList(list: List<PlanOfFoodModel>){
        listFood = list
        delViewModel = viewModel
        notifyDataSetChanged()
    }

}