package com.licoba.composego.constant

/**
 * 请求公共地址
 *
 * @author licoba
 * @since 2023/08/02
 */
object NetUrl {
    // BASE_URL一定要以/结尾，否则会崩溃
    const val RELEASE_URL = "https://www.wanandroid.com/"               // 正式服地址
    const val DEV_URL = "https://www.wanandroid.com/dev/"               // 联调测试地址
    const val TEST_URL = "https://www.wanandroid.com/test/"             // 测试服地址
    const val UAT_URL = "https://www.wanandroid.com/uat/"               // UAT环境地址
    const val MOCK_URL = "https://www.wanandroid.com/mock/"             // Mock测试地址

}