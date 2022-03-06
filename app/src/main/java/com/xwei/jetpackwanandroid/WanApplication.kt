package com.xwei.jetpackwanandroid

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import com.xwei.commonutils.util.LogUtil

/**
 * @desc
 * @author wei
 * @date  2022/3/1
 **/
class WanApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        // todo : 了解原理，为什么能监听生命周期
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}

class ApplicationObserver : DefaultLifecycleObserver {
    private val TAG = javaClass.simpleName

    override fun onCreate(owner: LifecycleOwner) {
        LogUtil.e(TAG, "--- onCreate ---")
    }

    override fun onStart(owner: LifecycleOwner) {
        LogUtil.e(TAG, "--- onStart ---")
    }

    override fun onResume(owner: LifecycleOwner) {
        LogUtil.e(TAG, "--- onResume ---")
    }

    override fun onPause(owner: LifecycleOwner) {
        LogUtil.e(TAG, "--- onPause ---")
    }

    override fun onStop(owner: LifecycleOwner) {
        LogUtil.e(TAG, "--- onStop ---")
    }

    /**
     *  永远不会被调用
     */
    override fun onDestroy(owner: LifecycleOwner) {
        LogUtil.e(TAG, "--- onDestroy ---")
    }
}

/**
 * 全局applicationContext
 */
lateinit var appContext: Context