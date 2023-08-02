package com.licoba.composego.core.network.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class UserDto(
    val errorCode: Long,
    val errorMsg: String,
)