package space.basyk.zametki.screens.plansofday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentPlanOfDayBinding
import space.basyk.zametki.databinding.FragmentPurposeBinding
import space.basyk.zametki.models.PlanOfDayModel
import space.basyk.zametki.screens.purpose.PurposeViewModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class PlanOfDayFragment : Fragment() {

    private var binding: FragmentPlanOfDayBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: PlanOfDayViewModel by viewModel()

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DayAdapter
    lateinit var observer: Observer<List<PlanOfDayModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanOfDayBinding.inflate(layoutInflater, container, false)
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
        viewModel.allDay.removeObserver(observer)
    }

    private fun initialization() {
        recyclerView = mBinding.recyclerOfDay
        adapter = DayAdapter()
        recyclerView.adapter = adapter
        observer = Observer {
            val list = it.asReversed()
            adapter.setList(list)
        }
        viewModel.allDay.observe(this, observer)
        mBinding.addOfDay.setOnClickListener {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_planOfDayFragment_to_addOfDayFragment)
        }
    }


}