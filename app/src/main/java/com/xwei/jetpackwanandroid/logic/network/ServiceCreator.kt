package com.xwei.jetpackwanandroid.logic.network

import com.xwei.jetpackwanandroid.constant.WanAndroid
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @desc
 * @author wei
 * @date  2022/3/1
 **/
object ServiceCreator {

    private val retrofit = Retrofit.Builder()
        .baseUrl(WanAndroid.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    // inline 意思是内联函数。表示直接执行方法体内代码，而不会有调用普通方法的压栈出栈耗费资源的行为。
    // 提升了性能，而且增加的代码量是在编译期执行的，对程序可读性不会造成影响。
    // reified 意思是具体化的。reified关键字是用于Kotlin内联函数的,修饰内联函数的泛型,泛型被修饰后,
    // 在方法体里,能从泛型拿到泛型的Class对象,这与java是不同的,java需要泛型且需要泛型的Class类型时,
    // 是要把Class传过来的,但是kotlin不用了
    inline fun <reified T> create(): T = create(T::class.java)
}