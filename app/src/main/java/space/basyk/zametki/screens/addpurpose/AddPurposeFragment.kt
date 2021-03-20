package space.basyk.zametki.screens.addpurpose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentAddPurposeBinding
import space.basyk.zametki.databinding.FragmentAddShopBinding
import space.basyk.zametki.databinding.FragmentPurposeBinding
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.screens.addshop.AddShopViewModel
import space.basyk.zametki.screens.purpose.PurposeViewModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class AddPurposeFragment : Fragment() {

    private var binding: FragmentAddPurposeBinding ?= null
    private val mBinding get() = binding!!
    private val viewModel: AddPurposeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPurposeBinding.inflate(layoutInflater, container, false)
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
        mBinding.addPurpose.setOnClickListener {
            val titlePurpose = mBinding.titlePurpose.text.toString()
            viewModel.insertPurpose(PurposeModel(titlePurpose = titlePurpose)){}
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_addPurposeFragment_to_purposeFragment)
        }
    }
}