package space.basyk.zametki.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentStartBinding
import space.basyk.zametki.utils.APP_ACTIVITY_START


class StartFragment : Fragment() {

    private var binding: FragmentStartBinding ?= null
    private val mBinding get() = binding!!
    private val viewModel: StartViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        viewModel.initDatabase {  }
        mBinding.btnSignin.setOnClickListener {
            APP_ACTIVITY_START.navController.navigate(R.id.action_testFragment_to_signInFragment)
        }

        mBinding.btnRegistr.setOnClickListener {
            APP_ACTIVITY_START.navController.navigate(R.id.action_testFragment_to_registrFragment)
        }
    }


}