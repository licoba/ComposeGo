package com.licoba.composego.core.network.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * wanAndroid开放API的数据结构定义
 * {
 *     "data": ...,
 *     "errorCode": 0,
 *     "errorMsg": ""
 * }
 */
@Serializable
@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    val errorCode: Long,
    val errorMsg: String,
    val `data`: T?
)