package com.xwei.jetpackwanandroid.constant

/**
 * @desc  玩Android 开放api 相关常量
 * @author wei
 * @date  2022/3/1
 **/
object WanAndroid {

    val BASE_URL = "https://www.wanandroid.com/"

    // 1.首页相关
    /**
     * 1.1 首页文章列表
     * 方法：GET
     * 参数：页码，拼接在连接中，从0开始。
      */
    val ARTICLE_LIST = "https://www.wanandroid.com/article/list/0/json"

    /**
     * 1.2 首页banner
     * 方法：GET
     * 参数：无
     */
    val BANNER = "https://www.wanandroid.com/banner/json"

}