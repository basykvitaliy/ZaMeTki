package space.basyk.zametki.screens.plansofeat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentPlanOfEatBinding
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class PlanOfEatFragment : Fragment() {
    private var binding: FragmentPlanOfEatBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: PlanOfEatViewModel by viewModel()

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: FoodAdapter
    lateinit var observer: Observer<List<PlanOfFoodModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanOfEatBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        recyclerView.adapter = null
        viewModel.allFood.removeObserver(observer)
    }

    private fun initialization() {
        recyclerView = mBinding.recyclerOfFood
        adapter = FoodAdapter(viewModel)
        recyclerView.adapter = adapter
        observer = Observer {
            val list = it.asReversed()
            adapter.setList(list)
        }
        viewModel.allFood.observe(this, observer)
        mBinding.addOfFood.setOnClickListener {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_planOfEatFragment_to_addOfFoodFragment)
        }

    }


}