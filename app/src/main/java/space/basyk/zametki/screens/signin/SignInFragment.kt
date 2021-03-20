package space.basyk.zametki.screens.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentSignInBinding
import space.basyk.zametki.utils.*


class SignInFragment : Fragment() {

    private var binding: FragmentSignInBinding ?= null
    private val mBinding get() = binding!!
    private val viewModel: SignInViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
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
        mBinding.btnSignin.setOnClickListener {
            val email = mBinding.inputEmail.text.toString()
            val password = mBinding.inputPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                EMAIL = email
                PASSWORD = password
                viewModel.initSignIn{
                    showToastTwo("Вы вошли как $EMAIL")
                    APP_ACTIVITY_START.navController.navigate(R.id.action_signInFragment_to_mainActivity)
                }
            }else{
                showToastTwo("Enter your email and password!")
            }

        }
    }

}