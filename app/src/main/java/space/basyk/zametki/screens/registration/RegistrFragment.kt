package space.basyk.zametki.screens.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentRegistrBinding
import space.basyk.zametki.utils.*


class RegistrFragment : Fragment() {

    private var binding: FragmentRegistrBinding ?= null
    private val mBinding get() = binding!!
    private val viewModel: RegistrViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrBinding.inflate(layoutInflater, container, false)
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
        mBinding.btnRegistr.setOnClickListener {
            val email = mBinding.inputEmailReg.text.toString()
            val password = mBinding.inputPasswordReg.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                EMAIL = email
                PASSWORD = password
                viewModel.createUser{
                    showToastTwo("Вы зарегистрировались")
                APP_ACTIVITY_START.navController.navigate(R.id.action_registrFragment_to_mainActivity)
                }
            }else{
                showToastTwo("Enter your email and password!")
            }

        }
    }

}