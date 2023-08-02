package com.licoba.composego.core.network.dtos

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val errorCode: Long,
    val errorMsg: String,
)