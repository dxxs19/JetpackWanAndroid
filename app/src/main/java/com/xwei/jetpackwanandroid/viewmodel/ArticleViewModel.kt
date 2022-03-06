package com.xwei.jetpackwanandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.xwei.jetpackwanandroid.logic.Repository
import com.xwei.jetpackwanandroid.logic.model.DataX
import com.xwei.jetpackwanandroid.paging.ArticleDataSource

/**
 * @desc 文章列表页
 * @author wei
 * @date  2022/3/1
 **/
class ArticleViewModel : BaseViewModel() {
    var dbArticles: LiveData<List<DataX>>? = null

    fun getArticles() = Pager(PagingConfig(20)) {
            ArticleDataSource()
        }.flow

    fun getAllArticles() {
        dbArticles = Repository.getAllArticlesLive()
    }

    fun insertArticles(articles: List<DataX>) {
        Repository.insertArticles(articles)
    }
}