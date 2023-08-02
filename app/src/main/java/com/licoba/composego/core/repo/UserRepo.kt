package com.licoba.composego.core.repo

interface UserRepo {
    suspend fun doLogin(username:String,password:String)
}
