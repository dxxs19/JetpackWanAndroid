package com.xwei.jetpackwanandroid.ui.main

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xwei.commonutils.ui.startActivity
import com.xwei.commonutils.util.LogUtil
import com.xwei.commonutils.util.TimerUtil
import com.xwei.jetpackwanandroid.R
import com.xwei.jetpackwanandroid.ui.base.BaseActivity
import com.xwei.jetpackwanandroid.databinding.ActivityMainBinding
import com.xwei.jetpackwanandroid.ui.test.TestActivity
import com.xwei.jetpackwanandroid.viewmodel.MainViewModel
import java.util.*

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun createBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        binding.viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.owner = this
    }

    override fun initView() {
        super.initView()
        val navView: BottomNavigationView = binding.bottomNav
        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        val navController = navHost.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_project, R.id.navigation_mine
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun initSetup() {
        super.initSetup()
//        binding.viewModel?.getCurrentSec()?.observe(this) { value ->
//            LogUtil.e(TAG, "value : $value")
//        }

    }
}