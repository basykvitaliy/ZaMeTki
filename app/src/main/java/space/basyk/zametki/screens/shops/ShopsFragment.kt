package space.basyk.zametki.screens.shops

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentShopsBinding
import space.basyk.zametki.models.ShopModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class ShopsFragment : Fragment() {

    private var binding: FragmentShopsBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: ShopsViewModel by viewModel()

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ShopsAdapter
    lateinit var observer: Observer<List<ShopModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopsBinding.inflate(layoutInflater, container, false)
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
        viewModel.allShops.removeObserver(observer)
    }

    private fun initialization() {
        recyclerView = mBinding.recyclerShops
        adapter = ShopsAdapter(viewModel)
        recyclerView.adapter = adapter
        observer = Observer {
            val list = it.asReversed()
            adapter.setList(list)
        }
        viewModel.allShops.observe(this, observer)
        mBinding.addShops.setOnClickListener {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_shopsFragment_to_addShopFragment)
        }
    }

}