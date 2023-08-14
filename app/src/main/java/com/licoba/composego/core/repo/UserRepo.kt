package com.licoba.composego.core.repo

import com.licoba.composego.core.net.dtos.UserDTO
import kotlinx.coroutines.flow.Flow

interface UserRepo:BaseRepository {
    suspend fun doLogin(username:String,password:String): Flow<UserDTO>
}
