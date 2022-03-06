package com.xwei.jetpackwanandroid.ui.base

import android.graphics.PixelFormat
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.xwei.commonutils.ui.StatusBarCompat
import com.xwei.jetpackwanandroid.R

/**
 * @desc
 * @author wei
 * @date  2022/3/1
 **/
abstract class BaseActivity : AppCompatActivity(), UIHost {
    protected val TAG = javaClass.simpleName

    override val hostView: View
        get() = window.decorView

    override fun onCreate(savedInstanceState: Bundle?) {
        initTheme()
        super.onCreate(savedInstanceState)

        createBinding()
        initializeFlow()
    }

    open fun initTheme() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFormat(PixelFormat.TRANSPARENT)
    }

    /**
     *  设置状态栏颜色
     */
    protected fun setStatusBarColor(colorId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StatusBarCompat.compat(this, ContextCompat.getColor(this, colorId))
        }
    }

//    private fun createBinding() {
//        val dataBinding = createDataBinding()
//        dataBinding.
//    }

    protected abstract fun createBinding()

//    protected abstract fun getLayoutId(): Int

}