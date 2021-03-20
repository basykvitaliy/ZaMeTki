package space.basyk.zametki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import space.basyk.zametki.databinding.ActivityMainBinding
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding ?= null
    private val mBinding get() = binding!!
    lateinit var navController: NavController
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY_MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNavigationView = mBinding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}