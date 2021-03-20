package space.basyk.zametki.screens.purpose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentPurposeBinding
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN


class PurposeFragment : Fragment() {

    private var binding: FragmentPurposeBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: PurposeViewModel by viewModel()

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PurposeAdapter
    lateinit var observer: Observer<List<PurposeModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPurposeBinding.inflate(layoutInflater, container, false)
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
        viewModel.allPurpose.removeObserver(observer)
    }

    private fun initialization() {
        recyclerView = mBinding.recyclerPurpose
        adapter = PurposeAdapter(viewModel)
        recyclerView.adapter = adapter
        observer = Observer {
            val list = it.asReversed()
            adapter.setList(list)
        }
        viewModel.allPurpose.observe(this, observer)
        mBinding.addPurpose.setOnClickListener {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_purposeFragment_to_addPurposeFragment)
        }
    }


}