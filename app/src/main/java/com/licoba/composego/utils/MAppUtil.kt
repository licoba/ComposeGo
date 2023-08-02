package com.licoba.composego.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import com.licoba.composego.BaseApp


object MAppUtil {
    fun isApkInDebug(): Boolean {
        return try {
            val info = BaseApp.context.applicationInfo
            info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
        } catch (e: Exception) {
            false
        }
    }

}