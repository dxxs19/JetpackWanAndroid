package com.xwei.jetpackwanandroid.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.xwei.jetpackwanandroid.databinding.FragmentProjectBinding
import com.xwei.jetpackwanandroid.ui.base.BaseFragment
import com.xwei.jetpackwanandroid.viewmodel.ProjectViewModel

/**
 * @desc
 * @author wei
 * @date  2022/3/1
 **/
class ProjectFragment : BaseFragment() {

    override fun getViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Boolean
    ): ViewDataBinding {
        val binding : FragmentProjectBinding = FragmentProjectBinding.inflate(inflater, container, b)
        binding.viewModel = ViewModelProvider(this)[ProjectViewModel::class.java]
        binding.owner = this
        return binding
    }

}