package com.licoba.composego

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * 自定义 Application 基类
 *
 * @author licoba
 * @since 2023/08/02
 * 所有使用 Hilt 的应用都必须包含一个带有 @HiltAndroidApp 注解的 Application 类
 *
 * HiltAndroidApp 在编译时会有一个警告。。。。
 */
@HiltAndroidApp
class BaseApp : Application() {

    init { INSTANCE = this }


    companion object {

        lateinit var INSTANCE: BaseApp
            private set

        val applicationContext: Context get() { return INSTANCE.applicationContext }


        // 全局CoroutineScope
        val mCoroutineScope by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CoroutineScope(
                SupervisorJob()
                        + Dispatchers.Default
                        + CoroutineName("BaseApplicationJob")
                        + CoroutineExceptionHandler { _, throwable ->
                    throwable.printStackTrace()
                })
        }
    }


    override fun onCreate() {
        super.onCreate()
        // 策略初始化第三方依赖
        initDepends()
    }


    private fun initDepends() {
        Timber.plant(Timber.DebugTree())
    }


}