package com.xwei.commonutils.util

import java.util.*

/**
 * @desc  时间操作工作类
 * @author wei
 * @date  2022/3/6
 **/
object TimerUtil {

    /**
     *  延迟多少毫秒开始，间隔多少毫秒重复
     */
    fun period(delay: Long = 0, period: Long = 1000, block: () -> Unit) {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                block()
            }
        }, delay, period)
    }

}