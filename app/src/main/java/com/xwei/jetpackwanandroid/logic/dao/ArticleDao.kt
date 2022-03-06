package com.xwei.jetpackwanandroid.logic.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.xwei.jetpackwanandroid.logic.model.DataX
import com.xwei.jetpackwanandroid.paging.ArticleDataSource

/**
 * @desc
 * @author wei
 * @date  2022/3/6
 **/
@Dao
interface ArticleDao {

    @Insert
    fun inserArticle(article: List<DataX>)

    @Query("SELECT * FROM article")
    fun getAllArticles(): LiveData<List<DataX>>

    /**
     *  返回一个 DataSource.Factory，这样就可以实现数据库的订阅。
     */
    @Query("SELECT * FROM article")
    fun getDBArticles(): DataSource.Factory<Int, DataX>

    @Query("select * from article where id = :id")
    fun getArticleById(id: Int): List<DataX>

    @Query("delete from article")
    fun clearArticles()
}