package com.xwei.jetpackwanandroid.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.xwei.commonutils.util.LogUtil
import com.xwei.jetpackwanandroid.R

class TestActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

    override fun onSupportNavigateUp(): Boolean {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        return if (fragment != null) {
            NavHostFragment.findNavController(fragment).navigateUp()
        } else {
            super.onSupportNavigateUp()
        }
    }
}