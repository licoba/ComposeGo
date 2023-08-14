package com.licoba.composego.core.net.dtos

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

/**
 * WanAndroid开放API的数据结构定义
 * {
 *     "data": ...,
 *     "errorCode": 0,
 *     "errorMsg": ""
 * }
 */
@Serializable
@JsonClass(generateAdapter = true)
data class WanResponse<T>(
    val errorCode: Int,
    val errorMsg: String,
    val `data`: T?
)