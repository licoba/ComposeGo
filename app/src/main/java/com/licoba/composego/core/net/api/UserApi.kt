package com.licoba.composego.core.net.api

import com.licoba.composego.core.net.dtos.WanResponse
import com.licoba.composego.core.net.dtos.UserDTO
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


// 网络接口层
interface UserApi {
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): WanResponse<UserDTO>


}