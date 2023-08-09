package com.licoba.composego.core.network.dtos

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

/**
 * DTO类由插件生成
 * https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass
 * Plugin 搜索 JSON To Kotlin Class 安装
 */
@Serializable
@JsonClass(generateAdapter = true)
data class UserDTO(
    val admin: Boolean = false,
    val chapterTops: List<Int>,
    val coinCount: Int,
    val collectIds: List<Int>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)