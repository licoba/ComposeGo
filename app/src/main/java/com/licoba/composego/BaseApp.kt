package com.licoba.composego

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.Log
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * 自定义 Application 基类
 *
 * @author licoba
 * @since 2023/08/02
 */
open class BaseApp : Application() {


    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        @get:JvmName("context")
        lateinit var context: Context
            private set

        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        @get:JvmName("application")
        lateinit var application: BaseApp
            private set

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

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
        application = this
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