package com.licoba.composego.core.repo

import com.licoba.composego.core.network.dtos.UserDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

interface UserRepo:BaseRepository {
    suspend fun doLogin(username:String,password:String): Flow<UserDTO>
}
