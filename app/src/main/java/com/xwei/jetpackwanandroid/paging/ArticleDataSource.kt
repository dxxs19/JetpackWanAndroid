package com.xwei.jetpackwanandroid.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xwei.commonutils.util.LogUtil
import com.xwei.jetpackwanandroid.logic.model.DataX
import com.xwei.jetpackwanandroid.logic.network.WanAndroidNetwork

/**
 * @desc
 * @author wei
 * @date  2022/3/5
 **/
class ArticleDataSource : PagingSource<Int, DataX>() {
    private val TAG = javaClass.simpleName

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataX> {
        return try {
            val currentPage = params.key ?: 1
//            LogUtil.e(TAG, "正在请求第 $currentPage 页数据")
            val response = WanAndroidNetwork.getArticles(currentPage)
            //当前页码 小于 总页码 页面加1
            val nextPage = if (currentPage < response.data.pageCount) {
                currentPage + 1
            } else {
                //没有更多数据
                null
            }
            LoadResult.Page(data = response.data.datas, prevKey = null, nextKey = nextPage)
        } catch (e: Exception) {
            LogUtil.e(TAG, "e: ${e.message}")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataX>): Int? {
//        TODO("Not yet implemented")
        return null
    }

}