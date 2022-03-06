package com.xwei.jetpackwanandroid.viewmodel

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.xwei.jetpackwanandroid.paging.ArticleDataSource

/**
 * @desc 文章列表页
 * @author wei
 * @date  2022/3/1
 **/
class ArticleViewModel : BaseViewModel() {

    fun getArticles() = Pager(PagingConfig(20)) {
            ArticleDataSource()
        }.flow

}