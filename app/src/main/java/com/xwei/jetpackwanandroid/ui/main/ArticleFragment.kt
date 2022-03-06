package com.xwei.jetpackwanandroid.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.xwei.commonutils.util.LogUtil
import com.xwei.jetpackwanandroid.R
import com.xwei.jetpackwanandroid.databinding.FragmentArticlesBinding
import com.xwei.jetpackwanandroid.ui.adapter.ArticlePagingDataAdapter
import com.xwei.jetpackwanandroid.ui.base.BaseFragment
import com.xwei.jetpackwanandroid.viewmodel.ArticleViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * @desc
 * @author wei
 * @date  2022/3/1
 **/
class ArticleFragment : BaseFragment() {
    val viewModel: ArticleViewModel by lazy { ViewModelProvider(this)[ArticleViewModel::class.java] }
    private lateinit var binding: FragmentArticlesBinding
    var pagingAdapter: ArticlePagingDataAdapter? = null

    override fun getViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Boolean
    ): ViewDataBinding {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false)
        binding.viewModel = this.viewModel
        binding.owner = this
        return binding
    }

    override fun initData() {
        super.initData()
    }

    override fun initView() {
        super.initView()
        pagingAdapter = ArticlePagingDataAdapter()
        binding.recyclerView.adapter = pagingAdapter
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.postDelayed({ binding.swipeRefresh.isRefreshing = false }, 2000)
        }
        viewModel.dbArticles?.observe(this) {
            it.forEach { item ->
                LogUtil.e(TAG, item.toString())
            }
        }
    }

    override fun initSetup() {
        super.initSetup()
        lifecycleScope.launch {
            viewModel.getArticles().collectLatest {
                pagingAdapter?.submitData(it)
            }
        }
    }
}