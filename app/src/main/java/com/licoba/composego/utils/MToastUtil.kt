package com.licoba.composego.utils

import android.graphics.Color
import android.view.Gravity
import android.widget.Toast
import com.blankj.utilcode.BuildConfig
import com.blankj.utilcode.util.ToastUtils
import com.licoba.composego.BaseApp
import com.licoba.composego.utils.MAppUtil.isApkInDebug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * 显示调试的Toast
 * @param text String  文本
 * @param isLong Boolean 是否长时间显示
 * @param gravity Int  位置
 */
fun showDebugToast(
    text: String,
    isLong: Boolean = false,
    gravity: Int = Gravity.CENTER
) {
    if (!isApkInDebug()) return
    ToastUtils.make()
        .setBgColor(Color.parseColor("#262626"))
        .setGravity(Gravity.CENTER, 0, 0)
        .setTextColor(Color.WHITE)
        .setDurationIsLong(isLong)
        .setGravity(gravity, 0, 0)
        .show("\uD83D\uDE05\n" + text)

}


/**
 * toast
 * @param text String
 */
fun showToast(text: String, durations: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.CENTER) {
    BaseApp.mCoroutineScope.launch(Dispatchers.Main) {
        ToastUtils.make()
            .setBgColor(Color.parseColor("#262626"))
            .setGravity(Gravity.CENTER, 0, 0)
            .setTextColor(Color.WHITE)
            .show(text)
    }
}
