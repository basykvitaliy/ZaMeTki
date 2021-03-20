package space.basyk.zametki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import space.basyk.zametki.databinding.ActivityFirstBinding
import space.basyk.zametki.utils.APP_ACTIVITY_START

class FirstActivity : AppCompatActivity() {

    private var binding: ActivityFirstBinding?= null
    private val mBinding get() = binding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY_START = this
        navController = Navigation.findNavController(this, R.id.fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}