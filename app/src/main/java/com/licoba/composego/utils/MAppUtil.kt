package com.licoba.composego.utils

import android.content.Context
import android.content.pm.ApplicationInfo


object MAppUtil {
    fun isApkInDebug(context: Context): Boolean {
        return try {
            val info = context.applicationInfo
            info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
        } catch (e: Exception) {
            false
        }
    }

}