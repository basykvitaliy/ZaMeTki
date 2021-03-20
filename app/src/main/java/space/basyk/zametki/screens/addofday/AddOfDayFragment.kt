package space.basyk.zametki.screens.addofday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentAddOfDayBinding
import space.basyk.zametki.databinding.FragmentAddShopBinding
import space.basyk.zametki.databinding.FragmentPlanOfDayBinding
import space.basyk.zametki.screens.addshop.AddShopViewModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class AddOfDayFragment : Fragment() {
    private var binding: FragmentAddOfDayBinding ?= null
    private val mBinding get() = binding!!
    private val viewModel: AddOfDayViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddOfDayBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    private fun initialization() {
        mBinding.addDay.setOnClickListener {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_addOfDayFragment_to_planOfDayFragment)
        }
    }
}