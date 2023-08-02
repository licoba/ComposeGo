package com.licoba.composego.core.repo

import com.licoba.composego.core.network.api.UserApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepoImpl @Inject constructor(
    private val api: UserApi,
) : UserRepo {
    override suspend fun doLogin(username: String, password: String) {
        api.login(username, password)
    }
}
