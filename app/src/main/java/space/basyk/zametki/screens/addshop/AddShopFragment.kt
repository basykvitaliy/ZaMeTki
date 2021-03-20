package space.basyk.zametki.screens.addshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentAddShopBinding
import space.basyk.zametki.models.ShopModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class AddShopFragment : Fragment() {

    private var binding: FragmentAddShopBinding ?= null
    private val mBinding get() = binding!!
    private val viewModel: AddShopViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddShopBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mBinding.addShop.setOnClickListener {
            val titleShop = mBinding.titleShop.text.toString()
            viewModel.insertShop(ShopModel(shopTitle = titleShop)){}
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_addShopFragment_to_shopsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}